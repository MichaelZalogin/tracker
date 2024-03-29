package ru.mch.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.mch.tracker.*;
import ru.mch.tracker.entity.Item;
import ru.mch.tracker.store.MemTracker;
import ru.mch.tracker.store.Store;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Find by id item");
        tracker.add(item);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Find by id item");
        UserAction action = new FindByNameAction(out);
        action.execute(input, tracker);
        assertEquals(out.toString(), item.toString() + System.lineSeparator());
    }
}