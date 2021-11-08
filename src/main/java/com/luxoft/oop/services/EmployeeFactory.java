package com.luxoft.oop.services;

import com.luxoft.oop.entity.Designer;
import com.luxoft.oop.entity.Developer;
import com.luxoft.oop.entity.Employee;
import com.luxoft.oop.entity.Manager;

import java.util.Random;

public class EmployeeFactory {

    protected Employee[] generateEmloyees(int size) {
        String[] maleName = {"James", "Robert", "John", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles"};
        String[] femaleName = {"Mary", "Patricia", "Jennifer", "Linda", "Elizabeth", "Barbara", "Susan", "Jessica", "Sarah", "Karen"};
        String[] genderArray = {"male", "female"};
        Employee[] employeeArray = new Employee[size];

        Random random = new Random();
        String name;
        int counter = 0;

        while (counter < size) {
            int decider = (int) (Math.random() * 3);
            if (decider ==  0) {
                continue;
            }

            String gender = randomFromArray(genderArray);
            if (gender.equals("male")) {
                name = randomFromArray(maleName);
            } else {
                name = randomFromArray(femaleName);
            }
            int id = counter;
            int age = 20 + random.nextInt(30);
            double salary = 5000 + Math.random() * 10_000;

            if (decider == 1) {
                int fixedBugs = random.nextInt(40);
                Developer employee = new Developer(id, name, age, gender, salary, fixedBugs);
                employeeArray[counter] = employee;
                counter++;
            } else if (decider == 2) {
                double rate = 1 + random.nextInt(12);
                int workedDays = 20 + random.nextInt(7);
                Designer employee = new Designer(id, name, age, gender, salary, rate, workedDays);
                employeeArray[counter] = employee;
                counter++;
            } else if (decider == 3) {
                Manager employee = new Manager(id, name, age, gender, salary);
                employeeArray[counter] = employee;
                counter++;
            }
        }
        return employeeArray;
    }

    private String randomFromArray(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);

        return array[index];
    }

}
