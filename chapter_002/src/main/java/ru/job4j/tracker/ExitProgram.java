package ru.job4j.tracker;

public class ExitProgram implements UserAction{

    private final int EXIT;
    private final String INFO;
    private StartUI sui;

    public ExitProgram(int EXIT, String INFO, StartUI sui) {
        this.EXIT = EXIT;
        this.INFO = INFO;
        this.sui = sui;
    }

    @Override
    public int key() {
        return EXIT;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        sui.setEnd();
    }

    @Override
    public String info() {
        return key() + " " + INFO;
    }
}
