package com.infosupport.codedocent.generics.variance;

import java.util.List;

public class FinanceAgile {

    public void pay(Employee e) { }

    public void payAll(List<? extends Employee> employees) {
        for (Employee e : employees) {
            e.pay();
        }
        // employees.add(new ProductOwner());
    }

    public void scaleUp(List<? super Employee> team) {
        for (Object o : team) {
            log(o);
        }
        team.add(new Employee());
        team.add(new Developer());
        team.add(new ProductOwner());
    }

    public void moveAllStars(List<? extends Employee> fromTeam, List<? super Employee> toTeam) {
        for (Employee employee : fromTeam) {
            if (employee.getLevel() >= 10) {
                fromTeam.remove(employee);
                toTeam.add(employee);
            }
        }
    }

    private void log(Object o) {
        System.out.println(o);
    }
}
