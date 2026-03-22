import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String drop = "DROP TABLE IF EXISTS cum";
            stmt.execute(drop);

            String create = """
                    CREATE TABLE cum (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
                    )
                    """;
            stmt.execute(create);

            System.out.println("Tạo bảng thành công!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}