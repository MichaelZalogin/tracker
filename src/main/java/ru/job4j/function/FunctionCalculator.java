package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {
    public List<Double> diapason(double start, double end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        list.add(start);
        Double apply = func.apply(() -> end);
        return list;
    }
}