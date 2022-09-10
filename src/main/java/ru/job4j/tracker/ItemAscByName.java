package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item name1, Item name2) {
        return name1.getName().compareTo(name2.getName());
    }
}