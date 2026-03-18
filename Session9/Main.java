package Session9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while(true){
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");

            int choice = sc.nextInt(); sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("1.Physical  2.Digital");
                    int type = sc.nextInt(); sc.nextLine();
                    Product p = ProductFactory.createProduct(type, sc);
                    db.add(p);
                    break;

                case 2:
                    for(Product pr : db.getAll()){
                        pr.displayInfo();
                    }
                    break;

                case 3:

                    break;

                case 4:
                    System.out.print("Nhập ID sản phẩm muốn xóa: ");
                    String id = sc.nextLine();
                    db.delete(id);
                    break;
                case 5:
                    System.out.println("Chương trình kết thúc");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}