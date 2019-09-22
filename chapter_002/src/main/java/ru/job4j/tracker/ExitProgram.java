package ru.job4j.tracker;

public class ExitProgram extends BaseAction {

    private StartUI sui;

    public ExitProgram(int add, String info, StartUI sui) {
        super(add, info);
        this.sui = sui;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        sui.setEnd();
    }
}
