package ru.mch.tracker;

import org.junit.jupiter.api.Test;
import ru.mch.tracker.entity.Item;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ItemAscByNameTest {

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
        List<Item> expected = List.of(item1, item2, item3, item4);
        items.sort(new ItemAscByName());
        assertThat(expected).isEqualTo(items);
    }
}