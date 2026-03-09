package Session2.Bai1;

import java.util.function.*;

class User {
    String username;
    String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User: " + username + " - Role: " + role;
    }
}

public class Bai1 {
    public static void main(String[] args) {

        User u = new User("chien", "ADMIN");

        // 1. Predicate: kiểm tra admin
        Predicate<User> isAdmin = user -> user.getRole().equals("ADMIN");
        System.out.println(isAdmin.test(u));

        // 2. Function: User -> String
        Function<User, String> getUsername = user -> user.getUsername();
        System.out.println(getUsername.apply(u));

        // 3. Consumer: in User
        Consumer<User> printUser = user -> System.out.println(user);
        printUser.accept(u);

        // 4. Supplier: tạo User mới
        Supplier<User> createUser = () -> new User("default", "USER");
        System.out.println(createUser.get());
    }
}