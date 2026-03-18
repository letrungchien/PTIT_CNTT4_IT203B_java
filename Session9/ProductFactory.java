package Session9;

import java.util.Scanner;

class ProductFactory {
    public static Product createProduct(int type, Scanner sc){
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Price: "); Double price = sc.nextDouble();

        if(type == 1){
            System.out.print("Weight: ");
            Double weight = sc.nextDouble();
            return new PhysicalProduct(id, name, price, weight);
        } else {
            System.out.print("Size: ");
            int size = sc.nextInt();
            return new DigitalProduct(id, name, price, size);
        }
    }
}
