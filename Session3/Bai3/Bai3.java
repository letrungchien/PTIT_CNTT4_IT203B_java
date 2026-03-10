package Session3.Bai3;

import java.util.List;
import java.util.Optional;

public class Bai3 {

    // Record User
    public record User(String username, String email) {}

    // Repository
    static class UserRepository {

        List<User> users = List.of(
                new User("alice", "alice@gmail.com"),
                new User("bob", "bob@yahoo.com"),
                new User("charlie", "charlie@gmail.com")
        );

        public Optional<User> findUserByUsername(String username) {
            return users.stream()
                    .filter(u -> u.username().equals(username))
                    .findFirst();
        }
    }

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        repo.findUserByUsername("alice")
                .ifPresentOrElse(
                        user -> System.out.println("Welcome " + user.username()),
                        () -> System.out.println("Guest login")
                );
    }
}