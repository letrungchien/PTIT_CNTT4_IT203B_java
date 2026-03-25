package Session14;

import java.sql.*;

public class TransferMoney {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ss14_th";
        String user = "root";
        String password = "123456";

        String fromId = "ACC01";
        String toId = "ACC02";
        double amount = 1000;

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            conn.setAutoCommit(false);


            String checkSql = "SELECT Balance FROM Accounts WHERE AccountId = ?";
            PreparedStatement psCheck = conn.prepareStatement(checkSql);
            psCheck.setString(1, fromId);
            ResultSet rs = psCheck.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Tài khoản không tồn tại");
            }

            double balance = rs.getDouble("Balance");
            if (balance < amount) {
                throw new SQLException("Không đủ tiền");
            }

            CallableStatement cs1 = conn.prepareCall("{CALL sp_UpdateBalance(?, ?)}");
            cs1.setString(1, fromId);
            cs1.setDouble(2, -amount);
            cs1.execute();


            CallableStatement cs2 = conn.prepareCall("{CALL sp_UpdateBalance(?, ?)}");
            cs2.setString(1, toId);
            cs2.setDouble(2, amount);
            cs2.execute();

            conn.commit();


            String showSql = "SELECT * FROM Accounts";
            PreparedStatement psShow = conn.prepareStatement(showSql);
            ResultSet rs2 = psShow.executeQuery();

            System.out.println("===== KẾT QUẢ =====");
            while (rs2.next()) {
                System.out.println(
                        rs2.getString("AccountId") + " - " +
                                rs2.getString("FullName") + " - " +
                                rs2.getDouble("Balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi -> rollback");

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
