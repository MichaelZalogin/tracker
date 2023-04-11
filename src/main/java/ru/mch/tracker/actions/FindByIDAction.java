package ru.mch.tracker.actions;

import ru.mch.tracker.Input;
import ru.mch.tracker.Output;
import ru.mch.tracker.store.Store;
import ru.mch.tracker.entity.Item;

public class FindByIDAction implements UserAction {

    private final Output out;

    public FindByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
