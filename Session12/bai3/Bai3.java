package Session12.bai3;

//Phần 1
//JDBC yêu cầu gọi registerOutParameter() trước khi thực thi vì chương trình cần khai báo trước kiểu dữ liệu của tham số đầu ra để JDBC biết cách nhận và chuyển dữ liệu từ Database về Java. Nếu không đăng ký trước, JDBC không biết kiểu dữ liệu để xử lý nên sẽ gây lỗi khi lấy giá trị.
//Nếu tham số đầu ra trong SQL là kiểu DECIMAL, trong Java cần đăng ký bằng hằng số: Types.DECIMAL


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
public class Bai3 {
    public static void getSurgeryFee(Connection conn) {
        try {
            CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");

            // truyền tham số đầu vào
            cstmt.setInt(1, 505);

            // đăng ký tham số đầu ra
            cstmt.registerOutParameter(2, Types.DECIMAL);

            // thực thi thủ tục
            cstmt.execute();

            // lấy giá trị trả về
            double cost = cstmt.getDouble(2);

            System.out.println("Chi phí phẫu thuật: " + cost);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
