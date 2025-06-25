package com.infosupport.codedocent.generics.howtocreate;

import com.infosupport.codedocent.generics.howtouse.NaturalNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {

    static NaturalNumbers naturalNumbers = new NaturalNumbers(10); // is an ArrayList<Integer>

    static List<String> abcd = Arrays.asList("A", "B", "C", "D");
    static List<String> strings = Arrays.asList("11", "12", "13");

    static List<Integer> integers = Arrays.asList(11, 12, 13);
    static List<Double> doubles = Arrays.asList(11.1, 12.2, 13.3);
    static List<Number> numbers = new ArrayList<>();
    static List<Object> objects = new ArrayList<>();

    /*
        2. Create a new
            a. generic class by declaring it
            b. generic method by declaring it
     */

    public static void main(String[] args) {
        // 2a
        useNewGenericClass();

        // 2b
        useNewGenericMethod();
    }

    private static void useNewGenericClass() {
        // Non-generic Box:
        // Box b = new Box();
        // b.setValue(1); // b.setValue("a");   // b.setValue("a");
        // int value = (int) b.getValue();
        // System.out.println(value);

        // Specific Box:
        // BoxInteger sbi = new BoxInteger();
        // bi.setValue(1);
        // int i = bi.getValue();
        // System.out.println(i);

        // Generic Boxes:
        // Box<Integer> gbi = new Box<Integer>();
        // gbi.setValue(1);
        // int j = gbi.getValue();
        // System.out.println(j);

        // Box<String> gbs = new Box<String>();
        // gbs.setValue("a");
        // String s = gbs.getValue();
        // System.out.println(value);
    }

    private static void useNewGenericMethod() {
        naturalNumbers.printAll();

        // Easy use cases: ------------
        // swap(naturalNumbers, 0, 9);
        // naturalNumbers.printAll();

        // var x = count(naturalNumbers, 4);
        // var y = count(naturalNumbers, 42);

        // append(naturalNumbers, integers);
        // append(abcd, strings);

        // append(naturalNumbers, strings); // Must be same type
        // append(naturalNumbers, numbers); // Must be same type

        // More complex use case: ------------

        // appendNumbers(naturalNumbers, integers);
        // appendNumbers(naturalNumbers, numbers); // Types are "compatible".
        // appendNumbers(naturalNumbers, objects);

        // appendNumbers(abcd, strings);           // Source must be Number or sub Number
        // appendNumbers(naturalNumbers, strings); // Destination must be Number or super Number

        // appendNumbers(objects, integers); // Can't append objects to integers
        // appendNumbers(objects, numbers);  // Can't append objects to numbers
        // appendNumbers(integers, doubles); // Can't append integers to doubles
        // appendNumbers(doubles, integers); // Can't append doubles to integers

        // - Source is called covariant.
        // - destination is called contravariant.
        // - and why doesn't addNewEmptyItem compile?

        // More next time!

    }
}
