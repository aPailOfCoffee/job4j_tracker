package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replaced = "New item name";
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "New item name", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replaced));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ShowAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
                + "=== Show all items ====" + ln
                + "Хранилище еще не содержит заявок" + ln
                + "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByName() {
        String ln = System.lineSeparator();
        String name = "This item";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item(name));
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
                + "=== Find items by name ====" + ln
                + item + ln
                + "Menu." + ln
                + "0. Find items by name" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindById() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );

        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ====" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        String ln = System.lineSeparator();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                + "0. Exit Program" + ln
                + "Wrong input, you can select: 0-0" + ln
                + "Menu." + ln
                + "0. Exit Program" + ln
        ));
    }
}