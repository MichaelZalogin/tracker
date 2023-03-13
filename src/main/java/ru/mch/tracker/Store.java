package ru.mch.tracker;

import ru.mch.tracker.entity.Item;

import java.util.List;

public interface Store extends AutoCloseable {

    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);
}