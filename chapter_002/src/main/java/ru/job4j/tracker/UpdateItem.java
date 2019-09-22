package ru.job4j.tracker;

/**
 * Edit item
 */
public class UpdateItem extends BaseAction {

    public UpdateItem(int add, String info) {
        super(add, info);
    }

    /**
     * Edit item
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Edit item --------------");
        String id = input.ask("Введите id заявки :");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("------------ Заявка с Id : " + id + " не обнаружена -----------");
            return;
        } else {
            System.out.println("------------ Заявка обнаружена -----------");
            System.out.println(item + "\n");
        }

        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        item = new Item(name, desc);
        item.setId(id);

        if (tracker.replace(id, item)) {
            System.out.println("------------ Заявка с Id : " + id + " успешно отредактирована -----------");
        } else {
            System.out.println("------------ ошибка редактирования -----------");
        }
    }
}
