package Session3.Bai2;

import java.util.List;

public class Bai2{

    public record User(String username, String email, Status status) {}

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alice", "alice@gmail.com", Status.ACTIVE),
                new User("bob", "bob@yahoo.com", Status.INACTIVE),
                new User("charlie", "charlie@gmail.com", Status.ACTIVE)
        );

        users.stream()
                .filter(u -> u.email().endsWith("@gmail.com"))
                .map(User::username)
                .forEach(System.out::println);

    }
}
