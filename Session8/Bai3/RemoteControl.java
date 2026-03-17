package Session8.Bai3;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private UndoManager undoManager;

    public RemoteControl(int slots, UndoManager undoManager) {
        onCommands = new Command[slots];
        offCommands = new Command[slots];
        this.undoManager = undoManager;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOn(int slot) {
        onCommands[slot].execute();
        undoManager.push(onCommands[slot]);
    }

    public void pressOff(int slot) {
        offCommands[slot].execute();
        undoManager.push(offCommands[slot]);
    }

    public void undo() {
        undoManager.undo();
    }
}
