package ru.mch.tracker.actions;

import ru.mch.tracker.Input;
import ru.mch.tracker.store.Store;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
