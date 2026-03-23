package Session12.bai4;

//Phần 1
//Trong đoạn code trên, mỗi lần lặp chương trình lại tạo mới Statement và gửi một câu SQL mới đến Database. Khi đó Database Server phải:
//Parse (phân tích cú pháp) câu lệnh SQL
//Tạo Execution Plan (kế hoạch thực thi)
//Nếu vòng lặp chạy 1000 lần, database phải thực hiện 2 bước này 1000 lần cho cùng một cấu trúc SQL, gây lãng phí CPU và tài nguyên server, làm chương trình chạy rất chậm.
//Trong khi đó, PreparedStatement chỉ biên dịch câu SQL một lần, sau đó chỉ thay đổi giá trị tham số nên giúp giảm tải cho Database và tăng tốc độ thực thi.


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class Bai4 {

    public void insertResults(Connection conn, List<TestResult> list) {
        try {
            // tạo câu lệnh SQL với tham số
            String sql = "INSERT INTO Results(data) VALUES (?)";

            // khởi tạo PreparedStatement một lần
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // lặp qua danh sách dữ liệu
            for (TestResult tr : list) {

                // gán giá trị tham số
                pstmt.setString(1, tr.getData());

                // thực thi
                pstmt.executeUpdate();
            }

            System.out.println("Thêm dữ liệu thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
