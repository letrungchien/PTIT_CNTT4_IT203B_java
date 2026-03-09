package Session2.Bai6;

public class Bai6 {

    public static void main(String[] args) {

        User user = new User("chien");

        UserProcessor processor = UserUtils::convertToUpperCase;

        String result = processor.process(user);

        System.out.println(result);
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

@FunctionalInterface
interface UserProcessor {
    String process(User u);
}

class UserUtils {
    public static String convertToUpperCase(User u) {
        return u.getUsername().toUpperCase();
    }
}
