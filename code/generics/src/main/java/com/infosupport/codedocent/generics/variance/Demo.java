package com.infosupport.codedocent.generics.variance;

import java.util.List;

public class Demo {

    void main() {
        Person p = new Person();
        Employee e = new Employee();
        Developer d = new Developer();
        List<Object> objects = List.of();
        List<Person> persons = List.of(p);
        List<Employee> employees = List.of(e);
        List<Developer> developers = List.of(d);

        Finance trad = new Finance("only for employees");

        // regular   invariant                 invariant
        trad.pay(p); trad.payAll(persons);     trad.scaleUp(persons);
        trad.pay(e); trad.payAll(employees);   trad.scaleUp(employees);
        trad.pay(d); trad.payAll(developers);  trad.scaleUp(developers);

        // invariant
        trad.scaleUpWith(persons, employees);

        // -------------------------------------------------------------

        FinanceAgile agile = new FinanceAgile("for every kind of person");

        // regular    co (same)                  contra (opposite)
        agile.pay(p); agile.payAll(persons);     agile.scaleUp(persons);
        agile.pay(e); agile.payAll(employees);   agile.scaleUp(employees);
        agile.pay(d); agile.payAll(developers);  agile.scaleUp(developers);

        // contra & co
        //                ? >= E     ? <= E
        agile.scaleUpWith(objects,   employees);
        agile.scaleUpWith(employees, employees);
        agile.scaleUpWith(persons,   developers);

    }
}
