package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(atts, comparator);

        Comparator<Attachment> compareByNameAsc = (left, right) ->
                left.getName().compareTo(right.getName());
        Arrays.sort(atts, compareByNameAsc);
        for (Attachment attachment : atts) {
            System.out.println(attachment);
        }

        Comparator<Attachment> compareByNameDesc = (left, right) ->
                right.getName().compareTo(left.getName());
        Arrays.sort(atts, compareByNameDesc);
        for (Attachment attachment : atts) {
            System.out.println(attachment);
        }
    }
}