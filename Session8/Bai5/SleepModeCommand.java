package Session8.Bai5;

public class SleepModeCommand implements Command {

    private Command[] commands;

    public SleepModeCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {

        System.out.println("Kich hoat Sleep Mode");

        for (Command c : commands) {
            c.execute();
        }
    }
}