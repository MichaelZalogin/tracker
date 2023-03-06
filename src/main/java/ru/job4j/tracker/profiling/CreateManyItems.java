package ru.job4j.tracker.profiling;

import ru.job4j.tracker.*;

/**
 * Класс служит для добавления n числа заявок. С помощью различных улит
 * для анализа памяти виртуальной машины и этого класса можно
 * провести анализ работы программы. Расширяет базовый функционал путём добавления
 * класса в меню List<UserAction> actions.
 */
public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        out.println("Добавлено заявок: " + count);
        return true;
    }
}