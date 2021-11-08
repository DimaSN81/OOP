package com.luxoft.oop.services;

import com.luxoft.oop.entity.Employee;
import com.luxoft.oop.entity.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    public void createEmployeesAndRunAllMetods() {
        int id = 7;
        String name = "";
        EmployeeFactory employeeFactory = new EmployeeFactory();
        EmployeeService employeeService = new EmployeeService(employeeFactory.generateEmloyees(10));

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("------------------------------------Print emloyees-----------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");

        employeeService.printEmployees();

        System.out.println("");
        System.out.println("--------------------------------Find by id-------------------------------------------");
        System.out.println("");

        try {
            Employee employee = employeeService.getById(id);
            System.out.println(employee.toString());
        } catch (NullPointerException exception) {
            System.out.println("No find by id: " + id);
        }

        System.out.println("");
        System.out.println("--------------------------------Find by name-----------------------------------------");
        System.out.println("");

        try {
            Employee employee = employeeService.getByName(employeeService.getById(8).getName());
            System.out.println(employee.toString());
        } catch (NullPointerException exception) {
            System.out.println("No find by name: " + name);
        }

        System.out.println("");
        System.out.println("---------------------------Calculate salary and bonys--------------------------------");
        System.out.println("");

        System.out.println("All salary and bonus: " +employeeService.calculateSalaryAndBonus());

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("------------------------------------Print emloyees-----------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");

        employeeService.printEmployees();

        System.out.println("");
        System.out.println("---------------------------Print emloyees sort by name-------------------------------");
        System.out.println("");

        employeeService.sortByName();
        employeeService.printEmployees();

        System.out.println("");
        System.out.println("-----------------------Print emloyees sort by name and salary------------------------");
        System.out.println("");

        employeeService.sortByNameAndSalary();
        employeeService.printEmployees();

        System.out.println("");
        System.out.println("-------------------------------------Edit emloyees-----------------------------------");
        System.out.println("");

        Manager manager = new Manager(4, "Barbara", 27, "female", 7500);
        Employee employee = employeeService.edit(manager);
        System.out.println(employee.toString());

        System.out.println("");
        System.out.println("");

        employeeService.printEmployees();

        System.out.println("");
        System.out.println("-----------------------------------Remove emloyees-----------------------------------");
        System.out.println("");

        employee =  employeeService.remove(6);
        System.out.println(employee.toString());

        System.out.println("");
        System.out.println("");

        employeeService.printEmployees();

    }

}