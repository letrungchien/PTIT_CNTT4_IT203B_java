package Session13.Bai4;

//  PHÂN TÍCH NGẮN GỌN

// Hệ thống bị chậm do N+1 Query:
// 1 query lấy bệnh nhân + N query lấy dịch vụ
// => 500 bệnh nhân = 501 query → rất chậm

//  Bẫy 1:
// Quá nhiều query → tăng tải DB → phản hồi 10–15s

//  Bẫy 2:
// Nếu dùng INNER JOIN → mất bệnh nhân chưa có dịch vụ

//  Giải pháp:
// - Dùng LEFT JOIN (1 query duy nhất)
// - Dùng Map để gom dữ liệu
// - Check NULL để tránh lỗi

//  Kết luận:
// N+1 Query → chậm
// LEFT JOIN + Map → nhanh + đủ dữ liệu

import java.sql.*;
import java.util.*;

class DichVu {
    int maDichVu;
    String tenDichVu;

    public DichVu(int ma, String ten) {
        this.maDichVu = ma;
        this.tenDichVu = ten;
    }
}
class BenhNhanDTO {
    int maBenhNhan;
    String tenBenhNhan;
    List<DichVu> dsDichVu = new ArrayList<>();

    public BenhNhanDTO(int ma, String ten) {
        this.maBenhNhan = ma;
        this.tenBenhNhan = ten;
    }
}
public class Bai4 {
    public static void main(String[] args) throws Exception {

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "123456");

        String sql = """
            SELECT bn.maBenhNhan, bn.tenBenhNhan,
                   dv.maDichVu, dv.tenDichVu
            FROM BenhNhan bn
            LEFT JOIN DichVuSuDung dv
            ON bn.maBenhNhan = dv.maBenhNhan
        """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Map<Integer, BenhNhanDTO> map = new LinkedHashMap<>();

        while (rs.next()) {
            int maBN = rs.getInt("maBenhNhan");

            if (!map.containsKey(maBN)) {
                String tenBN = rs.getString("tenBenhNhan");
                map.put(maBN, new BenhNhanDTO(maBN, tenBN));
            }

            BenhNhanDTO bn = map.get(maBN);

            int maDV = rs.getInt("maDichVu");

            if (!rs.wasNull()) { // tránh NullPointerException
                String tenDV = rs.getString("tenDichVu");
                bn.dsDichVu.add(new DichVu(maDV, tenDV));
            }
        }
        List<BenhNhanDTO> result = new ArrayList<>(map.values());

        System.out.println("Tổng bệnh nhân: " + result.size());
        conn.close();
    }
}
