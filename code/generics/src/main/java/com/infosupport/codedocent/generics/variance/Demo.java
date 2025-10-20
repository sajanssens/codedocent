package com.infosupport.codedocent.generics.variance;

import java.util.List;

public class Demo {

    void main() {
        Finance old = new Finance();
        Employee e = new Employee();
        Developer d = new Developer();
        List<Employee> employees = List.of(e);
        List<Developer> developers = List.of(d);

        old.pay(e);
        old.pay(d);

        old.payAll(employees);
        // old.payAll(developers);

        FinanceAgile modern = new FinanceAgile();
        modern.payAll(employees);
        modern.payAll(developers);




    }
}
