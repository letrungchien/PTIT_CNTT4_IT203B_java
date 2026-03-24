package Session13.Bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// PHÂN TÍCH LỖI TRANSACTION
// Trong JDBC, mặc định Auto-Commit = true
// => Mỗi executeUpdate() là 1 transaction riêng và tự commit
// => Khi lệnh 1 thành công → đã commit
// => Lệnh 2 lỗi → không rollback được lệnh 1
// ⇒ Vi phạm Atomicity

public class Bai1 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            conn.setAutoCommit(false);

            // 1. Trừ thuốc
            String sql1 = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE id = ?";
            ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, 1);
            ps1.executeUpdate();

            // 2. Lưu lịch sử
            String sql2 = "INSERT INTO Prescription_History(patient_id, medicine_id) VALUES (?, ?)";
            ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, 101);
            ps2.setInt(2, 1);
            ps2.executeUpdate();

            // Commit nếu OK
            conn.commit();

            System.out.println("Transaction thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Transaction thất bại!");
            e.printStackTrace();

        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}