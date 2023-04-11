package ru.mch.tracker;

import ru.mch.tracker.actions.*;
import ru.mch.tracker.profiling.CreateManyItems;
import ru.mch.tracker.profiling.DeleteAllItems;
import ru.mch.tracker.store.SqlTracker;
import ru.mch.tracker.store.Store;

import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new ShowAllAction(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new FindByIDAction(output),
                    new FindByNameAction(output),
                    new CreateManyItems(output),
                    new DeleteAllItems(output),
                    new Exit(output));
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}