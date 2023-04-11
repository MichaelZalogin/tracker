package ru.mch.tracker;

import ru.mch.tracker.entity.Item;
import ru.mch.tracker.store.MemTracker;
import ru.mch.tracker.store.Store;

import java.util.List;

public class SingleTracker {

    private static SingleTracker instance = null;
    private Store tracker = new MemTracker();

    private SingleTracker() {
    }

    public SingleTracker getSingleTracker() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public List<Item> findAll(Item item) {
        return tracker.findAll();
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item back) {
        return tracker.replace(id, back);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}