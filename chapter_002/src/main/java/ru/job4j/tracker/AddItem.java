package ru.job4j.tracker;

/**
 * Класс реализует добавленяи новый заявки в хранилище.
 */
public class AddItem implements UserAction {

    /**
     * Константа меню для добавления новой заявки.
     */
    private final int ADD;
    private final String INFO;

    public AddItem(int add, String info) {
        this.ADD = add;
        this.INFO = info;
    }

    @Override
    public int key() {
        return ADD;
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDesc());
    }

    @Override
    public String info() {
        return key() + " " + INFO;
    }
}
