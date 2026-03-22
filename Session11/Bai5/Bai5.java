package Bai5;
// 1. Trùng mã bác sĩ (Primary Key) → SQLException
// 2. Chuyên khoa nhập quá dài → lỗi vượt độ rộng cột
// 3. Bỏ trống tên / mã → dữ liệu không hợp lệ
// 4. Nhập sai định dạng (nếu có ngày/thông tin khác)
// 5. Mất kết nối DB → không thực thi được
// 6. SQL lỗi (sai cú pháp) → chương trình crash

import java.sql.*;
import java.util.*;

public class Bai5 {


    static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "123456"
        );
    }


    static class Doctor {
        String id, name, specialty;

        Doctor(String id, String name, String specialty) {
            this.id = id;
            this.name = name;
            this.specialty = specialty;
        }
    }


    static class DoctorDAO {
        Connection conn;

        DoctorDAO(Connection conn) {
            this.conn = conn;
        }

        void getAll() throws Exception {
            String sql = "SELECT * FROM Doctors";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("specialty")
                );
            }
        }

        void insert(Doctor d) {
            String sql = "INSERT INTO Doctors VALUES (?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, d.id);
                ps.setString(2, d.name);
                ps.setString(3, d.specialty);

                ps.executeUpdate();
                System.out.println(" Thêm thành công!");

            } catch (SQLException e) {
                System.out.println(" Lỗi: " + e.getMessage());
            }
        }

        void stats() throws Exception {
            String sql = "SELECT specialty, COUNT(*) total FROM Doctors GROUP BY specialty";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("specialty") + ": " + rs.getInt("total")
                );
            }
        }
    }


    static class DoctorService {
        DoctorDAO dao;

        DoctorService(DoctorDAO dao) {
            this.dao = dao;
        }

        void showAll() throws Exception {
            dao.getAll();
        }

        void addDoctor(Scanner sc) {
            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Tên: ");
            String name = sc.nextLine();

            System.out.print("Chuyên khoa: ");
            String spec = sc.nextLine();

            if (id.isEmpty() || name.isEmpty()) {
                System.out.println(" Không được để trống!");
                return;
            }

            dao.insert(new Doctor(id, name, spec));
        }

        void stats() throws Exception {
            dao.stats();
        }
    }


    public static void main(String[] args) {

        try (Connection conn = getConnection()) {


            Statement stmt = conn.createStatement();
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Doctors (
                    id VARCHAR(20) PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    specialty VARCHAR(100)
                )
            """);

            DoctorDAO dao = new DoctorDAO(conn);
            DoctorService service = new DoctorService(dao);

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Xem bác sĩ");
                System.out.println("2. Thêm bác sĩ");
                System.out.println("3. Thống kê chuyên khoa");
                System.out.println("4. Thoát");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("❌ Nhập số!");
                    continue;
                }

                switch (choice) {
                    case 1 -> service.showAll();
                    case 2 -> service.addDoctor(sc);
                    case 3 -> service.stats();
                    case 4 -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> System.out.println(" Sai lựa chọn!");
                }
            }

        } catch (Exception e) {
            System.out.println(" Lỗi hệ thống: " + e.getMessage());
        }
    }
}