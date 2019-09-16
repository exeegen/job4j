package ru.job4j.tracker;
/**
 * Find item by Id
 */
public class FindItemById implements UserAction{

    private final int FIND_BY_ID;
    private final String INFO;

    public FindItemById(int FIND_BY_ID, String INFO) {
        this.FIND_BY_ID = FIND_BY_ID;
        this.INFO = INFO;
    }

    @Override
    public int key() {
        return FIND_BY_ID;
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

    @Override
    public String info() {
        return key() + " " + INFO;
    }
}
