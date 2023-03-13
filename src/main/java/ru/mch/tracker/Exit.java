package ru.mch.tracker;

import ru.mch.tracker.actions.UserAction;

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