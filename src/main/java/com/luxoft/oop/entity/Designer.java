package com.luxoft.oop.entity;

public class Designer extends Employee{
    private double rate;
    private int workedDays;

    public Designer() {}

    public Designer(int id, String name, int age, String gender, double salary, double rate, int workedDays) {
        super(id, name, age, gender, salary);
        this.rate = rate;
        this.workedDays = workedDays;
    }

    public String toString() {
        return super.toString() + " rate: " + getId() +
                " workedDays: " + getWorkedDays();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }
}
