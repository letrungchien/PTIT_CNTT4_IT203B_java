package Bai2;
/*
PHẦN 1 - PHÂN TÍCH

- Lệnh if(rs.next()) chỉ kiểm tra và lấy DUY NHẤT 1 dòng đầu tiên.
- Sau khi gọi next(), con trỏ của ResultSet sẽ di chuyển xuống dòng tiếp theo.

Cụ thể:
- Ban đầu con trỏ nằm trước dòng đầu tiên.
- Gọi next() lần 1 → trỏ tới dòng 1
- Nếu dùng if → chỉ chạy 1 lần → in 1 bản ghi rồi dừng

Ngoài ra:
- Nếu bảng rỗng → next() trả về false → không vào if → có thể gây lỗi logic

Kết luận:
- Muốn in danh sách (nhiều dòng) → phải dùng while(rs.next())
*/
import java.sql.*;

public class Bai2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String pass = "123456";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT name, quantity FROM medicine")) {

            System.out.println("===== DANH MỤC THUỐC =====");

            boolean isEmpty = true;

            while (rs.next()) {
                isEmpty = false;
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");

                System.out.println(name + " - " + quantity);
            }

            if (isEmpty) {
                System.out.println("Kho không có thuốc");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
