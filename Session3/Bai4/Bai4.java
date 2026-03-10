package Session3.Bai4;

import java.util.*;

public class Bai4 {

    public record User(String username, String email) {}

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alice", "alice@gmail.com"),
                new User("bob", "bob@yahoo.com"),
                new User("alice", "alice2@gmail.com"),
                new User("charlie", "charlie@gmail.com")
        );

        Set<String> seen = new HashSet<>();
        List<User> uniqueUsers = new ArrayList<>();

        for (User u : users) {
            if (seen.add(u.username())) {
                uniqueUsers.add(u);
            }
        }

        uniqueUsers.forEach(System.out::println);
    }
}
