package ru.job4j.tracker;
/**
 * class all items.
 */
public class ShowItems implements UserAction{

    private final int SHOW;
    private final String INFO;

    public ShowItems(int SHOW, String INFO) {
        this.SHOW = SHOW;
        this.INFO = INFO;
    }

    @Override
    public int key() {
        return SHOW;
    }

    /**
     * Show all items.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Show all items --------------");
        for (Item i : tracker.findAll()) {
            System.out.println(i);
        }
        System.out.println("------------ end operation --------------");
    }

    @Override
    public String info() {
        return key() + " " + INFO;
    }
}
