package ru.mch.tracker.profiling;

import ru.mch.tracker.*;
import ru.mch.tracker.actions.UserAction;
import ru.mch.tracker.entity.Item;
import ru.mch.tracker.store.Store;

import java.util.List;

/**
 * Класс служит для удаления всех заявок. Используется в рамках задачи
 * профилирования приложения. Расширяет базовый функционал путём добавления
 * класса в меню List<UserAction> actions.
 */
public class DeleteAllItems implements UserAction {
    private final Output out;

    public DeleteAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete all items ===");
        List<Item> allItems = tracker.findAll();
        List<Integer> collect = allItems.stream()
                .map(Item::getId).toList();
        for (Integer integer : collect) {
            tracker.delete(integer);
        }
        out.println("=== Все заявки удалены ===");
        return true;
    }
}