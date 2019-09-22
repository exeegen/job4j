package ru.job4j.tracker;

/**
 * class all items.
 */
public class ShowItems extends BaseAction {

    public ShowItems(int add, String info) {
        super(add, info);
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
}
