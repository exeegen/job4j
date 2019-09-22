package ru.job4j.tracker;

/**
 * Find item by Id
 */
public class FindItemById extends BaseAction {

    public FindItemById(int add, String info) {
        super(add, info);
    }

    /**
     * Find item by Id
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Find item by Id --------------");
        String id = input.ask("Введите id заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не обнаружена -----------");
        }
    }
}
