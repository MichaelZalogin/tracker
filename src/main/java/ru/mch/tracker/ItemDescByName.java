package ru.mch.tracker;

import ru.mch.tracker.entity.Item;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item name1, Item name2) {
        return name2.getName().compareTo(name1.getName());
    }
}