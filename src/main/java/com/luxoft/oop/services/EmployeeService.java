package com.luxoft.oop.services;

import com.luxoft.oop.entity.Designer;
import com.luxoft.oop.entity.Developer;
import com.luxoft.oop.entity.Employee;
import com.luxoft.oop.entity.Manager;


public class EmployeeService {
    private static final int DEFAULT_INITIAL_KOEFFICIENT_FIXEDBUGS = 25;
    Employee[] employees;

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    //вывод на экран информации о сотрудниках
    void printEmployees() {
        for(Employee employee : employees ) {
            System.out.println(employee.toString());
        }
    }

    //возвращает количество денег необходимое для выплаты зарплат для всех сотрудников в этом месяце (пробегаем по всем сотрудникам, суммируем зарплату каждого с бонусом каждого)
    public double calculateSalaryAndBonus() {
        double result = 0;
        for (Employee employee : employees) {
            if (employee instanceof Developer) {
                result += employee.getSalary() + ((Developer) employee).getFixedBugs() * DEFAULT_INITIAL_KOEFFICIENT_FIXEDBUGS;
            } else if (employee instanceof Manager) {
                result += employee.getSalary();
            } else if (employee instanceof Designer) {
                result += employee.getSalary() + ((Designer) employee).getRate() * ((Designer) employee).getWorkedDays();
            }
        }
        return result;
    }

    //возвращает сотрудника по заданному id
    public Employee getById(long id) {
        for (Employee employee : employees) {
            if (employee.getId() == (int) id) {
                return employee;
            }
        }
        return null;
    }

    //возвращает сотрудника по заданному имени
    public Employee getByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee[] sortByName() {
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i].getName().compareToIgnoreCase(employees[i + 1].getName()) < 0) {
                Employee value = employees[i];
                employees[i] = employees[i + 1];
                employees[i +1] = value;
                if (i > 0) {
                    for (int j = i; j > 0; j--) {
                        if (employees[j].getName().compareToIgnoreCase(employees[j - 1].getName()) > 0) {
                            value = employees[j];
                            employees[j] = employees[j - 1];
                            employees[j - 1] = value;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return employees;
    }

    //возвращают отсортированный массив с сотрудниками по критерию
    public Employee[] sortByNameAndSalary() {
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i].getName().compareToIgnoreCase(employees[i + 1].getName()) < 0) {
                Employee value = employees[i];
                employees[i] = employees[i + 1];
                employees[i +1] = value;
                if (i > 0) {
                    for (int j = i; j > 0; j--) {
                        if (employees[j].getName().compareToIgnoreCase(employees[j - 1].getName()) > 0) {
                            value = employees[j];
                            employees[j] = employees[j - 1];
                            employees[j - 1] = value;
                        } else {
                            break;
                        }
                    }
                }
            } else if (employees[i].getName().compareToIgnoreCase(employees[i + 1].getName()) == 0) {
                if(employees[i].getSalary() > employees[i + 1].getSalary()) {
                    Employee value = employees[i] ;
                    employees[i] = employees[i + 1];
                    employees[i + 1] = value;
                    if (i > 0) {
                        for (int j = i; j > 0; j--) {
                            if(employees[j].getName().compareToIgnoreCase(employees[j - 1].getName()) == 0){
                                if (employees[j].getSalary() < employees[j - 1].getSalary()) {
                                    value = employees[j];
                                    employees[j] = employees[j - 1];
                                    employees[j - 1] = value;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return employees;
    }

    //находит сотрудника по id, и подменяет информацию о нем на новую. Старую версию сотрудника метод возвращает.
    public Employee edit(Employee employee) {
        Employee oldWorker = getById(employee.getId());
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == employee.getId()) {
                employees[i] = employee;
                break;
            }
        }
        return oldWorker;
    }

    //находит сотрудника по id, и удаляет его из массива. Возвращает ссылку на удаленного сотрудника.
    public Employee remove(long id) {
        Employee oldWorker = getById(id);
        Employee[] tempEmployees = new Employee[employees.length - 1];
        int index = 0;
        for (Employee value : employees) {
            if(value.getId() != id) {
                tempEmployees[index] = value;
                index++;
            }
        }
        employees = tempEmployees;
        return oldWorker;
    }
}
