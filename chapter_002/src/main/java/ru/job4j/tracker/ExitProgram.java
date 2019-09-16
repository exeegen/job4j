package ru.job4j.tracker;

public class ExitProgram implements UserAction{

    private final int EXIT;
    private final String INFO;

    public ExitProgram(int EXIT, String INFO) {
        this.EXIT = EXIT;
        this.INFO = INFO;
    }

    @Override
    public int key() {
        return EXIT;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        /*
        здесь делаем input.close() и tracker.save()
         */
        System.out.println("завершение сеанса");
        System.exit(0);
    }

    @Override
    public String info() {
        return key() + " " + INFO;
    }
}
