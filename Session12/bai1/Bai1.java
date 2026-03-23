package Session12.bai1;

//Phần 1
//**PreparedStatement** được coi là “tấm khiên” chống **SQL Injection** vì nó **không nối trực tiếp dữ liệu người dùng vào câu SQL** mà sử dụng các **tham số `?`**.
//Cơ chế **Pre-compiled (biên dịch trước)** nghĩa là câu lệnh SQL được **database biên dịch trước khi gán giá trị tham số**. Sau đó dữ liệu người dùng được truyền vào bằng các phương thức như `setString()` và được coi là **dữ liệu thuần**, không phải một phần của câu lệnh SQL.
//Nhờ vậy, dữ liệu nhập vào **không thể thay đổi cấu trúc câu SQL**, giúp **ngăn chặn hiệu quả SQL Injection**.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bai1 {
    public boolean login(Connection conn, String code, String pass) {
        boolean check = false;

        try {
            String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, code);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                check = true; // đăng nhập thành công
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
}
