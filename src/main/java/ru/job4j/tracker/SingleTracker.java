package ru.job4j.tracker;

public class SingleTracker {

    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public SingleTracker getSingleTracker() {
        if (instance == null) {
            return new SingleTracker();
        } else {
            return instance;
        }
    }

    public Item add(Item item) {
        return null;
    }

    public Item findById(int id) {
        return null;
    }

    public Item[] findAll() {
        return null;
    }

    public Item[] findByName(String key) {
        return null;
    }

    private int indexOf(int id) {
        return 0;
    }

    public boolean replace(int id, Item tack) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }
}