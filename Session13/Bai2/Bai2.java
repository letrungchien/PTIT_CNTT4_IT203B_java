package Session13.Bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// ================= PHÂN TÍCH LỖI =================
//
// Trong JDBC, khi đã setAutoCommit(false)
// => Các câu lệnh SQL được gom vào cùng 1 Transaction
//
// Tuy nhiên, nếu xảy ra lỗi mà trong khối catch
// chỉ dùng System.out.println() để in lỗi
// => KHÔNG xử lý transaction
//
//  Vấn đề:
// - Giao dịch đang ở trạng thái dang dở (chưa commit)
// - Không rollback → transaction bị treo
// - Có thể giữ lock dữ liệu → ảnh hưởng hệ thống
//
//  Vi phạm nguyên tắc Atomicity:
// Khi thất bại → phải rollback toàn bộ
//
//  Hành động bị thiếu:
// conn.rollback();
//
// =================================================

public class Bai2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            //  Tắt Auto-Commit
            conn.setAutoCommit(false);

            // 1. Trừ tiền ví bệnh nhân
            String sql1 = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, 500000);
            ps1.setInt(2, 101);
            ps1.executeUpdate();

            // 2. Cập nhật trạng thái hóa đơn
            String sql2 = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";
            ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, 999);
            ps2.executeUpdate();


            conn.commit();
            System.out.println("Thanh toán thành công!");

        } catch (Exception e) {

            //  BẮT BUỘC rollback khi có lỗi
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
                    conn.setAutoCommit(true); // reset lại
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
