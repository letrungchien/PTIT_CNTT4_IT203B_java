package Session12.bai2;

//Các phương thức như setDouble() và setInt() của PreparedStatement giúp lập trình viên không cần lo về định dạng số (dấu chấm hoặc dấu phẩy) vì JDBC sẽ tự động chuyển đổi dữ liệu Java sang đúng định dạng mà Database yêu cầu.
//Dữ liệu được truyền vào theo đúng kiểu dữ liệu (double, int,...) thay vì nối chuỗi SQL, nên tránh được lỗi định dạng số do khác biệt locale của hệ điều hành và đảm bảo câu lệnh SQL luôn hợp lệ.

import java.sql.Connection;
import java.sql.PreparedStatement;
public class Bai2 {
    public void updateTemperature(Connection conn, double temp, int patientId) {
        try {
            String sql = "UPDATE Vitals SET temperature = ? WHERE p_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, temp);
            pstmt.setInt(2, patientId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Cập nhật chỉ số thành công!");
            } else {
                System.out.println("Không tìm thấy bệnh nhân.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
