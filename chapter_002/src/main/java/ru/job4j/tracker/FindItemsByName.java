package ru.job4j.tracker;

/**
 * Find items by name
 */
public class FindItemsByName extends BaseAction {

    public FindItemsByName(int add, String info) {
        super(add, info);
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
}
