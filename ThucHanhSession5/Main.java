package ThucHanhSession5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        int chon = 0;

        do{
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trìrình");
            System.out.println("=============================================");
            System.out.println("Nhập lựa chọn :");
            chon=sc.nextInt();

            switch (chon){
                case 1 -> {
                    System.out.println("Thêm sản phẩm");
                    System.out.print("Nhập ID: ");
                    int idp = sc.nextInt();
                    sc.nextLine();
                 long check= products.stream().filter(e->e.getId()==idp).count();
                    if(check>0){
                        System.out.println("id đã tồn tại");
                        return;
                    }


                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();

                    System.out.print("Nhập số lượng: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhập loại: ");
                    String category = sc.nextLine();
                  Product p= new Product(category,idp,name,price,quantity);
                  products.add(p);
                  System.out.println("Thêm thành công ");
                }
                case 2 ->{
                        System.out.println("==> Danh sách sản phẩm:");
                if (products.isEmpty()) {
                    System.out.println("Danh sách trống!");
                } else {
                    for (Product prod : products) {
                        System.out.println("ID: " + prod.getId() +
                                " | Tên: " + prod.getName() +
                                " | Giá: " + prod.getPrice() +
                                " | SL: " + prod.getQuantity() +
                                " | Loại: " + prod.getCategory());
                    }
                }
            }
                case 3 -> System.out.println("case 3");
                case 4 -> System.out.println("case 4");
                case 5 -> System.out.println("Chương trình kết thúc :)");
                default -> System.out.println("Lựa chọn không hợp lệ !");

            }

        }while (chon != 5);

    }

}

