package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream pstr = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String menu = "Меню."
            + "0. Add new Item\n"
            + "1. Show all items\n"
            + "2. Edit item\n"
            + "3. Delete item\n"
            + "4. Find item by Id\n"
            + "5. Find items by name\n"
            + "6. Exit Program\n"
            + "Select: ";

    @Before
    public void beforTesting() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void afterTesting() {
        System.setOut(pstr);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerHasItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "beleberda"));
        Item item2 = tracker.add(new Item("test2", "beleberda dada"));
        Item[] items = new Item[]{item2};
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenShouAllThenItemsOut() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "beleberda"));
        Item item2 = tracker.add(new Item("test2", "beleberda dada"));

        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();

        String resalt = new String(out.toByteArray());

        StringBuilder exp = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator())
                .append("------------ Show all items --------------")
                .append(System.lineSeparator())
                .append(item1)
                .append(System.lineSeparator())
                .append(item2)
                .append(System.lineSeparator())
                .append("------------ end operation --------------")
                .append(System.lineSeparator())
                .append(menu)
                .append(System.lineSeparator());

        assertThat(resalt, is(exp.toString()));
    }

    @Test
    public void whenFindItemByIdThenItemOut() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "beleberda"));
        Item item2 = tracker.add(new Item("test2", "beleberda dada"));

        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        new StartUI(input, tracker).init();

        String resalt = new String(out.toByteArray());

        StringBuilder exp = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator())
                .append("------------ Find item by Id --------------")
                .append(System.lineSeparator())
                .append(item1)
                .append(System.lineSeparator())
                .append(menu)
                .append(System.lineSeparator());

        assertThat(resalt, is(exp.toString()));
    }

    @Test
    public void whenFindItemsByNameThenItemsOut() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "beleberda"));
        Item item2 = tracker.add(new Item("test2", "beleberda dada"));
        Item item3 = tracker.add(new Item("test1", "dada"));

        Input input = new StubInput(new String[]{"5", "test1", "6"});
        new StartUI(input, tracker).init();

        String resalt = new String(out.toByteArray());

        StringBuilder exp = new StringBuilder()
                .append(menu)
                .append(System.lineSeparator())
                .append("------------ Find items by name --------------")
                .append(System.lineSeparator())
                .append(item1)
                .append(System.lineSeparator())
                .append(item3)
                .append(System.lineSeparator())
                .append("------------ end operation --------------")
                .append(System.lineSeparator())
                .append(menu)
                .append(System.lineSeparator());

        assertThat(resalt, is(exp.toString()));
    }

}
