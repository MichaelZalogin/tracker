package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LazyBoot {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthCmp);

        String[] name2 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp2 = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(name2, lengthCmp2);
    }
}