package ru.mch.tracker;

import ru.mch.tracker.actions.UserAction;
import ru.mch.tracker.store.Store;

public class Exit implements UserAction {

    private final Output out;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}