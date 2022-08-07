package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.*;

public class StartUI {
    public static void main(String[] args) {
        Item item1 = new Item();
        LocalDateTime nowDateTime = item1.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(nowDateTime.format(formatter));
        Item item2 = new Item();
        System.out.println(item2);
    }
}
