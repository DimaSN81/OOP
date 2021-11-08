package com.luxoft.oop.entity;

import com.luxoft.oop.entity.Employee;

public class Manager extends Employee {

    public Manager(){}

    public Manager(int id, String name, int age, String gender, double salary) {
        super(id, name, age, gender, salary);
    }

    public String toString() {
        return super.toString();
    }

}
