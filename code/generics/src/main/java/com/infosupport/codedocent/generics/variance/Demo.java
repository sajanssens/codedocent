package com.infosupport.codedocent.generics.variance;

import java.util.List;

public class Demo {

    void main() {
        Person p = new Person();
        Employee e = new Employee();
        Developer d = new Developer();
        List<Person> persons = List.of(p);
        List<Employee> employees = List.of(e);
        List<Developer> developers = List.of(d);

        Finance traditional = new Finance();

        traditional.pay(p);             // regular sub typing
        traditional.pay(e);
        traditional.pay(d);

        traditional.payAll(persons);    // in variant
        traditional.payAll(employees);
        traditional.payAll(developers);

        traditional.scaleUp(persons);   // in variant
        traditional.scaleUp(employees);
        traditional.scaleUp(developers);

        traditional.scaleUpWith(employees, developers);   // in variant

        FinanceAgile agile = new FinanceAgile();

        agile.pay(p);          // regular sub typing
        agile.pay(e);
        agile.pay(d);

        agile.payAll(persons); // co variant
        agile.payAll(employees);
        agile.payAll(developers);

        agile.scaleUp(persons);   // contra variant
        agile.scaleUp(employees);
        agile.scaleUp(developers);

        agile.scaleUpWith(employees, developers); // contra & co
    }
}
