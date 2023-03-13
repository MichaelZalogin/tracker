package ru.mch.tracker;

import ru.mch.tracker.entity.Item;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item name1, Item name2) {
        return name1.getName().compareTo(name2.getName());
    }
}