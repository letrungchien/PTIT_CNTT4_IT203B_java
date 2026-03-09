package Session2.Bai4;

import java.util.*;
import java.util.function.*;

class User {
    String username;

    public User() {
        this.username = "defaultUser";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Bai4 {
    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        users.add(new User("chien"));
        users.add(new User("an"));
        users.add(new User("binh"));


        Function<User, String> getUsername = User::getUsername;


        Consumer<String> print = System.out::println;


        Supplier<User> createUser = User::new;


        users.stream()
                .map(getUsername)
                .forEach(print);

        User u = createUser.get();
        print.accept(u.getUsername());
    }
}
