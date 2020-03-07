package com.thandaaye.javaabstract.entity;

public class Parent extends Person {

    public String getId() {
        return "3";
    }

    public String getEducationHistory() {
        return "educationHistory";
    }

    @Override
    public String getLabel() {
        return getEducationHistory();
    }
}
