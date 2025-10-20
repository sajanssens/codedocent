package com.infosupport.codedocent.generics.howtocreate.genericclass;

//              vvv type parameter
public class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
