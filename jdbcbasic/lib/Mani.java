import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mani {
    private static Connection conn;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            initConnection();
            while(true) {
                System.out.println("-------Menu-------");
                System.out.println("1. Hien thi danh sach benh nhan");
                System.out.println("2. Them benh nhan moi");
                System.out.println("3. Xoa benh nhan");
                System.out.println("0. Thoat");
                System.out.println("Nhap lua chon: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch(choice){
                    case 1:
                        displayPatients();
                        break;
                    case 2:
                        System.out.println("Nhap ten benh nhan: ");
                        String fullName = sc.nextLine();
                        System.out.println("Nhap tuoi benh nhan: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.println("Nhap chuan doan cua benh nhan: ");
                        String diagnosis = sc.nextLine();
                        addPatient(fullName, age, diagnosis);
                        break;
                    case 3:
                        System.out.println("Nhap id benh nhan can xoa: ");
                        int id = Integer.parseInt(sc.nextLine());
                        deletePatient(id);
                        break;
                    case 0:
                        System.out.println("Thoat chuong trinh");
                        return;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }
            }
        } catch (Exception e ) {
            System.out.println("Co loi xay ra: " + e);
        } finally {
            closeConnection();
        }
    }

    public static void displayPatients() throws Exception {
        String select = "SELECT * from patients;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(select);

        while(rs.next()) {
            int id = rs.getInt("id");
            String fullName = rs.getString("full_name");
            int age = rs.getInt("age");
            String diagnosis = rs.getString("diagnosis");
            System.out.println("Id: " + id + ", Ten: " + fullName + ", Tuoi: " + age + ", Chuan doan: " + diagnosis);
        }
    }
    public static void addPatient(String fullName, int age, String diagnosis) throws Exception {
        String insert = "INSERT INTO patients (full_name, age, diagnosis) VALUES ('" + fullName + "', " + age + ", '" + diagnosis + "');";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(insert);
        if (count > 0) {
            System.out.println("Benh nhan da duoc them thanh cong.");
        } else {
            System.out.println("Them benh nhan that bai.");
        }
    }

    public static void deletePatient(int id) throws Exception {
        String deletePrepared = "DELETE FROM patients where id = ?;";
        String delete = "DELETE FROM patients where id = " + id + ";";
        Statement stmt = conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(deletePrepared);
        pstmt.setInt(1, id);
        int count = pstmt.executeUpdate();
        if (count > 0) {
            System.out.println("Benh nhan da duoc xoa thanh cong.");
        } else {
            System.out.println("Xoa benh nhan that bai.");
        }
    }

    public static void initConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String user = "root";
        String password = "123456";
        conn = DriverManager.getConnection(url, user, password);
    }
    public static void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {}
    }

}