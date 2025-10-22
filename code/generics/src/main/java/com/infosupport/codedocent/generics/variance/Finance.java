package com.infosupport.codedocent.generics.variance;

import java.util.List;

public class Finance {

    public void pay(Employee e) { e.pay(); }

    public void payAll(List<Employee> employees) {
        for (Employee e : employees) {
            e.pay();
        }
        employees.add(new ProductOwner());
    }

    public void scaleUp(List<Employee> team) {
        for (Employee o : team) {   // read Object
            log(o);
        }
        team.add(new Employee()); // write Employee
        team.add(new Developer());
        team.add(new ProductOwner());
    }

    public void scaleUpWith(List<Employee> team, List<Employee> source) {
        for (Employee e : source) { // read Employee
            team.add(e);            // write Employee
        }
    }

    private void log(Object o) {
        System.out.println(o);
    }
}
