import java.sql.*;

public class main {

    static final String URL = "jdbc:mysql://localhost:3306/test";
    static final String USER = "root";
    static final String PASS = "123456";

    // CREATE
    public static void insertStudent(String name, int age) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        String sql = "INSERT INTO student(name, age) VALUES(?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.executeUpdate();
        System.out.println("Thêm thành công");
    }

    // READ
    public static void getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        String sql = "SELECT * FROM student";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getInt("id") + " - " +
                    rs.getString("name") + " - " +
                    rs.getInt("age"));
        }
    }

    // UPDATE
    public static void updateStudent(int id, String name, int age) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        String sql = "UPDATE student SET name=?, age=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, id);
        ps.executeUpdate();
        System.out.println("Cập nhật thành công");
    }

    // DELETE
    public static void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Xóa thành công");
    }

    public static void main(String[] args) throws Exception {
        insertStudent("Chien", 19);
        insertStudent("An", 20);

        System.out.println("Danh sách:");
        getAllStudents();

        updateStudent(1, "Chien Dep Trai", 20);

        deleteStudent(2);

        System.out.println("Sau khi update + delete:");
        getAllStudents();
    }
}