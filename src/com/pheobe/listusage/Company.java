package com.pheobe.listusage;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public boolean addEmployee(Employee employee) {
        boolean exist = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.equals(employee)) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return false;
        } else {
            employees.add(employee);
            return true;
        }
    }

    public int numberOfSameEmployees(Company company) {
        int count = 0;
        ArrayList<Employee> otherEmployees = company.getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            boolean exist = false;
            for (int j = 0; j < otherEmployees.size(); j++) {
                Employee e = otherEmployees.get(j);
                if (employee.equals(e)) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        String info = name + "\n";
        for (int i = 0; i < employees.size(); i++) {
            info += employees.get(i).toString() + "\n";
        }
        return info;
    }

    public boolean equals(Company other) {
        return name.equals(other.getName());
    }
}
