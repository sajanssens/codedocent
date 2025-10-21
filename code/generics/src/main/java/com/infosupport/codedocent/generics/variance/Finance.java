package com.infosupport.codedocent.generics.variance;

import java.util.List;

public class Finance {

    public void pay(Employee e) { }

    public void payAll(List<Employee> employees) { }

    public void scaleUp(List<Employee> team) { }

    public void scaleUpWith(List<Employee> team, List<Employee> source) { }
}
