package ru.job4j.tracker;

/**
 * Delete item
 */
public class DeleteItem implements UserAction {
    /**
     * Delete item
     */
    private final int DELETE;
    private final String INFO;

    public DeleteItem(int add, String info) {
        this.DELETE = add;
        this.INFO = info;
    }

    @Override
    public int key() {
        return DELETE;
    }

    /**
     * Delete item
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Delete item --------------");
        String id = input.ask("Введите id заявки :");
        if (tracker.delete(id)) {
            System.out.println("------------ Заявка с Id : " + id + " удалена -----------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не обнаружена -----------");
        }
    }

    @Override
    public String info() {
        return key() + " " + INFO;
    }
}
