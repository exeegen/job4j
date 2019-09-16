package ru.job4j.tracker;
/**
 * Find items by name
 */
public class FindItemsByName implements UserAction{

    private final int FIND_BY_NAME;
    private final String INFO;

    public FindItemsByName(int FIND_BY_NAME, String INFO) {
        this.FIND_BY_NAME = FIND_BY_NAME;
        this.INFO = INFO;
    }

    /**
     * Find items by name
     */
    @Override
    public int key() {
        return FIND_BY_NAME;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find items by name --------------");
        String name = input.ask("Введите название заявки :");
        Item[] item = tracker.findByName(name);
        for (Item i : item) {
            System.out.println(i);
        }
        System.out.println("------------ end operation --------------");
    }

    @Override
    public String info() {
        return key() + " " + INFO;
    }
}
