package com.luxoft.oop.entity;

public class Developer extends Employee{
    private int fixedBugs;

    public Developer() {}

    public Developer(int id, String name, int age, String gender, double salary, int fixedBugs) {
        super(id, name, age, gender, salary);
        this.fixedBugs = fixedBugs;
    }

    public String toString() {
        return super.toString() + " fixedBugs: " + getFixedBugs();
    }

    public int getFixedBugs() {
        return fixedBugs;
    }

    public void setFixedBugs(int fixedBugs) {
        this.fixedBugs = fixedBugs;
    }



}
