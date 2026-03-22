package Bai3;

// executeUpdate() trả về số dòng bị ảnh hưởng (int)
// Nếu > 0: cập nhật thành công (có giường tồn tại)
// Nếu = 0: không có dòng nào bị cập nhật → mã giường không tồn tại

// => Dựa vào giá trị này để phản hồi:
// rows == 0 → báo lỗi "Mã giường không tồn tại"
// rows > 0 → cập nhật thành công


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bai3 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/session11";
        String user = "root";
        String pass = "123456";

        String bedId = "B01";
        String sql = "UPDATE beds SET bed_status = ? WHERE bed_id = ?";

        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setString(1, "Đang sử dụng");
            ps.setString(2, bedId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cập nhật thành công giường: " + bedId);
            } else {
                System.out.println("Lỗi: Mã giường không tồn tại!");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());
        }
    }
}