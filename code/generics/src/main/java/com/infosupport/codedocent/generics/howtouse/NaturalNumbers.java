package com.infosupport.codedocent.generics.howtouse;

import java.util.ArrayList;

//                                            vvvvvvv = type argument
public class NaturalNumbers extends ArrayList<Integer> {

    public NaturalNumbers() {
        for (int i = 1; i <= 3; i++) { add(i); }
    }

    public int sumFirstLast() {
        return getFirst() + getLast();
    }

    public void printAll() { forEach(System.out::println); }
}
