package Session13.Bai3;

import java.sql.*;

public class Bai3 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        int patientId = 101;
        int bedId = 5;
        double amount = 500000;

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            // ================= BẪY 1: CHECK SỐ DƯ =================
            String checkBalance = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkBalance);
            psCheck.setInt(1, patientId);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new Exception("Bệnh nhân không tồn tại");
            }

            double balance = rs.getDouble("balance");

            //  Không đủ tiền → rollback
            if (balance < amount) {
                throw new Exception("Không đủ tiền");
            }

            // ================= UPDATE 1: TRỪ TIỀN =================
            String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            int row1 = ps1.executeUpdate();

            // ================= UPDATE 2: GIƯỜNG =================
            String sql2 = "UPDATE Beds SET status = 'EMPTY' WHERE bed_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, bedId);
            int row2 = ps2.executeUpdate();

            // ================= UPDATE 3: BỆNH NHÂN =================
            String sql3 = "UPDATE Patients SET status = 'DISCHARGED' WHERE patient_id = ?";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, patientId);
            int row3 = ps3.executeUpdate();

            // ================= BẪY 2: ROW AFFECTED =================
            //  Nếu không có dòng nào bị update → dữ liệu ảo
            if (row1 == 0 || row2 == 0 || row3 == 0) {
                throw new Exception("Dữ liệu không tồn tại");
            }


            conn.commit();
            System.out.println("Thanh toán thành công");

        } catch (Exception e) {

            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Transaction thất bại: " + e.getMessage());

        } finally {
            try {
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