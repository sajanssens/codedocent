package com.infosupport.codedocent.generics.variance;

import java.util.List;

import static java.lang.IO.println;

public class FinanceAgile {

    public void pay(Employee e) { e.pay(); }

    public void payAll(List<? extends Employee> employees) {
        for (Employee e : employees) {
            e.pay();
        }
        // employees.add(new ProductOwner());
    }

    public void scaleUp(List<? super Employee> team) {
        for (Object o : team) {   // read Object
            log(o);
        }
        team.add(new Employee()); // write Employee
        team.add(new Developer());
        team.add(new ProductOwner());
    }

    public void scaleUpWith(List<? super Employee> team, List<? extends Employee> source) {
        for (Employee e : source) { // read Employee
            team.add(e);            // write Employee
        }
    }

    private void log(Object o) { println(o); }
}
