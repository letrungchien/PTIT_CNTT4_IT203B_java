package dmo;



import java.util.Scanner;

public class User {
    private String userId;
    private String userName;
    private int age;
    private String role;
    private double score;

    public User() {}

    public User(String userId, String userName, int age, String role, double score) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public void inputData(Scanner sc){
        System.out.print("Nhập mã: ");
        userId = sc.nextLine();

        System.out.print("Nhập tên: ");
        userName = sc.nextLine();

        while(true){
            System.out.print("Nhập tuổi (>=18): ");
            age = Integer.parseInt(sc.nextLine());
            if(age >= 18) break;
            System.out.println("Tuổi phải >=18");
        }

        while(true){
            System.out.print("Nhập role (USER/ADMIN): ");
            role = sc.nextLine();
            if(role.equalsIgnoreCase("USER") || role.equalsIgnoreCase("ADMIN"))
                break;
            System.out.println("Role không hợp lệ");
        }

        while(true){
            System.out.print("Nhập score (0-10): ");
            score = Double.parseDouble(sc.nextLine());
            if(score >=0 && score <=10) break;
        }
    }

    public void displayData(){
        System.out.printf("%-6s %-15s %-5d %-10s %-5.2f\n",
                userId,userName,age,role,score);
    }
}