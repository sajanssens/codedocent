package com.infosupport.codedocent.generics.variance;

public class Employee {
    private int level = 0;

    public void pay() { }

    public int getLevel() {
        return level;
    }
}

class Developer extends Employee { }

class ProductOwner extends Employee { }
