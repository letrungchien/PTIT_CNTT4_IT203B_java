package Session1.Baitap.Bai6;

import java.time.LocalDateTime;

public class Logger {

    public static void logError(String message) {

        System.out.println("[ERROR] " + LocalDateTime.now() + " - " + message);

    }
}