package com.infosupport.codedocent.generics.howtocreate.genericmethod;

import java.util.List;

public class NumbersUtil {

    public static <T> void swap(List<T> aList, int index1, int index2) {
        T e1 = aList.get(index1);
        T e2 = aList.get(index2);
        aList.set(index1, e2);
        aList.set(index2, e1);
    }

    public static <T> int count(List<T> aList, T item) {
        return aList.stream()
                .filter(item::equals)
                .toList()
                .size();
    }

    //             T may be any type, e.g. Integer, String, Person, ...
    public static <T> void append(
            List<T> source,
            List<T> destination) {
        for (T item : source) {
            destination.add(item);
        }
    }

    //             T must be at least a Number (i.e. Number, Integer, Float, ...)
    public static <T extends Number> void appendNumbers(
            List<? extends T> source,   // must be a list instance of at least Number (Number or sub)
            List<? super T> destination // must be a list instance of at most Number  (Number or super)
    ) {
        for (T item : source) {
            destination.add(item);
        }
    }

    public static <T> void addNewEmptyItem(List<T> source) {
        // destination.add(new T()); // doesn't work. Why?
    }
}
