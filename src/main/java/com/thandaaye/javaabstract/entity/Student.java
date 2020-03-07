package com.thandaaye.javaabstract.entity;

public class Student extends Person {

    public String getId() {
        return "2";
    }

    public String getInterests() {
        return "interests";
    }

    @Override
    public String getLabel() {
        return getInterests();
    }
}
