package ru.job4j.tracker;

/**
 * Delete item
 */
public class DeleteItem extends BaseAction {

    public DeleteItem(int add, String info) {
        super(add, info);
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

}
