package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] copyItemArray = new Item[items.length];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                copyItemArray[index] = items[i];
                index++;
            }
        }
        return Arrays.copyOf(copyItemArray, index);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item tack) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            tack.setId(id);
            items[index] = tack;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = null;
            System.arraycopy(items, 1 + index, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}