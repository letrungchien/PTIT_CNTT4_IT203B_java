package Session8.Bai3;

import java.util.Stack;

public class UndoManager {
    private Stack<Command> history = new Stack<>();

    public void push(Command command) {
        history.push(command);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
        } else {
            System.out.println("Khong co lenh de undo");
        }
    }
}
