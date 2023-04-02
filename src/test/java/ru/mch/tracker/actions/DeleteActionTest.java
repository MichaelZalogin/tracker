package ru.mch.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.mch.tracker.*;
import ru.mch.tracker.entity.Item;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        UserAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertEquals(out.toString(), "=== Delete item ===" + ln
                                     + "Заявка удалена успешно." + ln);
    }
}