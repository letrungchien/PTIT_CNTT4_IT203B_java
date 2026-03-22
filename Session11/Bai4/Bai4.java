package Bai4;

// Khi nối chuỗi trực tiếp:
// SELECT * FROM patients WHERE name = ' + input + '

// Nếu hacker nhập:
// ' OR '1'='1

// Câu SQL thành:
// SELECT * FROM patients WHERE name = '' OR '1'='1'
import java.sql.*;

public class Bai4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO user(name, age) VALUES (?, ?)";


            ps = conn.prepareStatement(sql);

            ps.setString(1, "Chiến");
            ps.setInt(2, 19);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Thêm thành công!");
            } else {
                System.out.println("Thêm thất bại!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}