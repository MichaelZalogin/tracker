package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {

    @Test
    void compare() {
        Item item1 = new Item(1, "item1");
        Item item2 = new Item(2, "item2");
        Item item3 = new Item(3, "item3");
        Item item4 = new Item(4, "item4");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item3);
        items.add(item4);
        items.add(item2);
        List<Item> expected = List.of(item4, item3, item2, item1);
        items.sort(new ItemDescByName());
        assertThat(expected).isEqualTo(items);
    }
}