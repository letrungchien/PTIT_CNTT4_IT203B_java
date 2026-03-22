/*
PHẦN 1 - PHÂN TÍCH

Vấn đề:
- Hệ thống liên tục tạo Connection mới nhưng không đóng lại (close).
- Không có cơ chế quản lý tập trung (connection pool).

Hậu quả:
- Gây rò rỉ tài nguyên (Connection leak).
- Cơ sở dữ liệu chỉ cho phép số lượng kết nối giới hạn.
- Sau một thời gian hoạt động, hệ thống sẽ hết connection.
- Dẫn đến lỗi: "Communications link failure".
- Ứng dụng có thể bị treo hoặc không truy cập được database.

Ảnh hưởng trong hệ thống y tế:
- Hệ thống cần hoạt động 24/7.
- Nếu bị treo sẽ không truy xuất được hồ sơ bệnh nhân.
- Có thể gây gián đoạn công việc và ảnh hưởng đến an toàn bệnh nhân.

Kết luận:
- Cần đóng Connection, Statement, ResultSet sau khi sử dụng.
- Nên sử dụng finally hoặc try-with-resources.
- Có thể dùng connection pool để quản lý hiệu quả hơn.
*/
package Bai1;
import java.sql.*;

public class Bai1 {

    // hằng số cấu hình
    private static final String URL = "jdbc:mysql://localhost:3306/session11";
    private static final String USER = "root";
    private static final String PASS = "123456";

    // lấy connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // ví dụ query
    public static void getPatients() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM patients");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                        rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // đóng theo thứ tự ngược
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (st != null) st.close(); } catch (Exception ignored) {}
            try { if (conn != null) conn.close(); } catch (Exception ignored) {}
        }
    }
}
