package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item name1, Item name2) {
        return name2.getName().compareTo(name1.getName());
    }
}