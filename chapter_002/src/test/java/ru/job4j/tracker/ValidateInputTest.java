package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private final ByteArrayInputStream inputStream = new ByteArrayInputStream(("ugjhjk"
            + System.lineSeparator()
            + "2"
            + System.lineSeparator()
            + "1"
            + System.lineSeparator()).getBytes());
    private final InputStream in = System.in;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
        System.setIn(inputStream);
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
        System.setIn(in);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new ConsoleInput());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        input.ask("Enter", list);

        assertThat(this.mem.toString(), is("Enter"
                + System.lineSeparator()
                + "Введите корректное значение"
                + System.lineSeparator()
                + "Enter"
                + System.lineSeparator()
                + "Введите пункт меню в диапазоне 0 - 1 : "
                + System.lineSeparator()
                + "Enter"
                + System.lineSeparator()));
    }
}
