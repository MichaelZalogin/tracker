package ru.mch.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.mch.tracker.*;
import ru.mch.tracker.entity.Item;
import ru.mch.tracker.store.MemTracker;
import ru.mch.tracker.store.Store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReplaceActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        UserAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Edit item ===" + ln + "Заявка изменена успешно." + ln);
        assertEquals(tracker.findAll().get(0).getName(), replacedName);
    }
}