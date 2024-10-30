package com.infosupport.codedocent.generics.howtouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

    /*
        1. Use existing
            a. generic class by
                - instantiating it
                - extending it
            b. generic method by
                - calling it
     */

    public static void main(String[] args) {
        useRawTypes();

        // 1a1
        // useGenericClass();

        // 1a2
        // extendGenericClass();

        // 1b
        callGenericMethod();
    }

    private static void useRawTypes() {
        List naturalNumbers = new ArrayList();

        naturalNumbers.add(1);
        naturalNumbers.add(2);
        naturalNumbers.add(3);

        // We get "objects", not ints
        Object first = naturalNumbers.getFirst();
        Object last = naturalNumbers.getLast();

        // We have to cast them...
        int firstInt = (int) first;
        int lastInt = (int) last;

        int sum = firstInt + lastInt;

        for (Object number : naturalNumbers) {
            System.out.println((int) number);
        }
    }

    private static void useGenericClass() {
        List<Number> naturalNumbers = new ArrayList<>();
        //   ^^^^^^ = type argument

    }

    private static void extendGenericClass() {
        // First see NaturalNumbers.java

        // Now use it:
        NaturalNumbers nums = new NaturalNumbers();
        int sum = nums.sumFirstLast();
        nums.printAll();
    }

    private static void callGenericMethod() {
        List<Integer> ints = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        // addAll works on ints
        Collections.addAll(ints, 1, 2, 3, 4);

        // addAll works on strings
        Collections.addAll(strings, "A", "B", "C", "D");

        // addAll works on ... any type!

        // how does it know the actual type for each call?
        // i.e. where's the type argument?
        Collections.<Integer>addAll(ints, 5, 6, 7);
    }
}
