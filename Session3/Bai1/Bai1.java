package Session3.Bai1;

import java.util.List;

public class Bai1 {

    public record User(String username, String email, Status status) {}

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    public static void main(String[] args) {

        User u1 = new User("alice", "alice@gmail.com", Status.ACTIVE);
        User u2 = new User("bob", "bob@gmail.com", Status.INACTIVE);
        User u3 = new User("charlie", "charlie@gmail.com", Status.ACTIVE);

        List<User> users = List.of(u1, u2, u3);

        users.forEach(user ->
                System.out.println(user.username() + " - " + user.status())
        );
    }
}
