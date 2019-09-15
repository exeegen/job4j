package ru.job4j.tracker;

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Show all items
     */
    private static final String SHOW = "1";

    /**
     * Edit item
     */
    private static final String EDIT = "2";

    /**
     * Delete item
     */
    private static final String DELETE = "3";

    /**
     * Find item by Id
     */

    private static final String FIND_BY_ID = "4";

    /**
     * Find items by name
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");

            switch (answer) {
                case ADD:
                    createItem();
                    break;
                case SHOW:
                    showItems();
                    break;
                case EDIT:
                    editItem();
                    break;
                case DELETE:
                    deleteItem();
                    break;
                case FIND_BY_ID:
                    findById();
                    break;
                case FIND_BY_NAME:
                    findItemsByName();
                    break;
                case EXIT:
                    exit = true;
                default:
                    continue;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
    }

    /**
     * Show all items.
     */
    private void showItems() {
        System.out.println("------------ Show all items --------------");
        for (Item i : this.tracker.findAll()) {
            System.out.println(i);
        }
        System.out.println("------------ end operation --------------");
    }

    /**
     * Edit item
     */
    private void editItem() {
        System.out.println("------------ Edit item --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("------------ Заявка с Id : " + id + " не обнаружена -----------");
            return;
        }

        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");

        item.setName(name);
        item.setDesc(desc);
        System.out.println("------------ Заявка с Id отредактирована -----------\n"
                + item + "\n--------------------------------");
    }

    /**
     * Delete item
     */
    private void deleteItem() {
        System.out.println("------------ Delete item --------------");
        String id = this.input.ask("Введите id заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка с Id : " + id + " удалена -----------");
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не обнаружена -----------");
        }
    }

    /**
     * Find item by Id
     */
    private void findById() {
        System.out.println("------------ Find item by Id --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Заявка с Id : " + id + "  -----------");
            System.out.println(item);
        } else {
            System.out.println("------------ Заявка с Id : " + id + " не обнаружена -----------");
        }
    }

    /**
     * Find items by name
     */
    private void findItemsByName() {
        System.out.println("------------ Find items by name --------------");
        String name = this.input.ask("Введите название заявки :");
        Item[] item = this.tracker.findByName(name);

        System.out.println("------------ Заявки с названием : " + name + "  -----------");
        for (Item i : item) {
            System.out.println(i);
        }
        System.out.println("------------ end operation --------------");
    }

    private void showMenu() {
        System.out.println("Меню."
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n"
                + "Select: ");
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
