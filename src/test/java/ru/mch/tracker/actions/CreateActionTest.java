package ru.mch.tracker.actions;

import org.junit.jupiter.api.Test;
import ru.mch.tracker.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("New item");
        UserAction action = new CreateAction(out);
        action.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("New item");
    }
}