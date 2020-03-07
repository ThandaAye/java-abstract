package com.thandaaye.javaabstract.entity;

public class Teacher extends Person {

    public String getId() {
        return "1";
    }

    public String getExperience() {
        return "experience";
    }

    @Override
    public String getLabel() {
        return getExperience();
    }
}
