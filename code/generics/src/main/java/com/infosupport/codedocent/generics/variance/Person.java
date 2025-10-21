package com.infosupport.codedocent.generics.variance;

public class Person { }

class Employee extends Person {
    public void pay() { }
}

class Developer extends Employee { }

class ProductOwner extends Employee { }
