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
    private ByteArrayInputStream inputStream;
    private final InputStream in = System.in;
    private List<Integer> list = new ArrayList<>();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
        list.add(0);
        list.add(1);
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
        System.setIn(in);
    }

    @Test
    public void whenInvalidInput() {
        inputStream = new ByteArrayInputStream(("ugjhjk"
                + System.lineSeparator()
                + "1"
                + System.lineSeparator()).getBytes());
        System.setIn(inputStream);
        ValidateInput input = new ValidateInput(new ConsoleInput());
        input.ask("Enter", list);
        assertThat(this.mem.toString(), is("Enter"
                + System.lineSeparator()
                + "Введите корректное значение"
                + System.lineSeparator()
                + "Enter"
                + System.lineSeparator()));
    }

    @Test
    public void whenMenuOutException() {
        inputStream = new ByteArrayInputStream(("6"
                + System.lineSeparator()
                + "1"
                + System.lineSeparator()).getBytes());
        System.setIn(inputStream);
        ValidateInput input = new ValidateInput(new ConsoleInput());
        input.ask("Enter", list);
        assertThat(this.mem.toString(), is("Enter"
                + System.lineSeparator()
                + "Введите пункт меню в диапазоне 0 - 1 : "
                + System.lineSeparator()
                + "Enter"
                + System.lineSeparator()));
    }
}
