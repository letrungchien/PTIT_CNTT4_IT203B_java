package Session2.Bai3;

public class Bai3 {
    public static void main(String[] args) {
        
        String password = "123456";

        String encrypted = Authenticatable.encrypt(password);

        System.out.println("Password sau khi mã hóa: " + encrypted);
    }
}

@FunctionalInterface
interface Authenticatable {

    String getPassword();

    default boolean isAuthenticated(String password) {
        return !password.isBlank();
    }

    static String encrypt(String rawPassword) {
        return new StringBuilder(rawPassword).reverse().toString();
    }
}