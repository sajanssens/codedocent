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
}
