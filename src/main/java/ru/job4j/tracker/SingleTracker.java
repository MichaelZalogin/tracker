package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {

    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

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