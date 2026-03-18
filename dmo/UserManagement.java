package dmo;


import java.util.Optional;
import java.util.Scanner;

public class UserManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserBusiness business = UserBusiness.getInstance();

        while(true){

            System.out.println("******** QUẢN LÝ NGƯỜI DÙNG ********");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm người dùng");
            System.out.println("3. Cập nhật người dùng");
            System.out.println("4. Xóa người dùng");
            System.out.println("5. Tìm theo tên");
            System.out.println("6. Lọc ADMIN");
            System.out.println("7. Sắp xếp theo score");
            System.out.println("8. Thoát");

            int choice = Integer.parseInt(sc.nextLine());

            switch(choice){

                case 1:
                    business.displayList();
                    break;

                case 2:
                    User u = new User();
                    u.inputData(sc);
                    business.addUser(u);
                    break;

                case 3:
                    System.out.print("Nhập id cần sửa: ");
                    String id = sc.nextLine();

                    Optional<User> opt = business.findById(id);

                    if(opt.isPresent()){
                        User user = opt.get();

                        System.out.print("Tên mới: ");
                        user.setUserName(sc.nextLine());

                        System.out.print("Tuổi: ");
                        user.setAge(Integer.parseInt(sc.nextLine()));

                        System.out.print("Role: ");
                        user.setRole(sc.nextLine());

                        System.out.print("Score: ");
                        user.setScore(Double.parseDouble(sc.nextLine()));

                    }else{
                        System.out.println("Mã người dùng không tồn tại trong hệ thống");
                    }
                    break;

                case 4:
                    System.out.print("Nhập id cần xóa: ");
                    business.deleteUser(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    business.searchByName(sc.nextLine());
                    break;

                case 6:
                    business.filterAdmin();
                    break;

                case 7:
                    business.sortByScore();
                    break;

                case 8:
                    return;
            }
        }
    }
}
