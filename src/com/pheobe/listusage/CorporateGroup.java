package com.pheobe.listusage;

import java.util.ArrayList;

public class CorporateGroup {
    private ArrayList<Company> companies;

    public CorporateGroup() {
        companies = new ArrayList<>();
    }

    public boolean addCompany(Company company) {
        boolean exist = false;
        for (int i = 0; i < companies.size(); i++) {
            Company c = companies.get(i);
            if (c.equals(company)) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return false;
        } else {
            companies.add(company);
            return true;
        }
    }

    public int addCompanies(ArrayList<Company> newCompanies) {
        int count = 0;
        for (int i = 0; i < newCompanies.size(); i++) {
            Company c = newCompanies.get(i);
            boolean exist = false;
            for (int j = 0; j < companies.size(); j++) {
                Company cc = companies.get(j);
                if (cc.equals(c)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                companies.add(c);
                count++;
            }
        }
        return count;
    }

    public String fetchEmployee(String registry) {
        boolean found = false;
        String companyNames = "";
        String employeeName = "";
        for (int i = 0; i < companies.size(); i++) {
            Company c = companies.get(i);
            ArrayList<Employee> employees = c.getEmployees();
            boolean exist = false;
            for (int j = 0; j < employees.size(); j++) {
                Employee e = employees.get(j);
                if (registry.equals(e.getRegistry())) {
                    found = true;
                    exist = true;
                    employeeName = e.getName();
                    break;
                }
            }
            if (exist) {
                companyNames += " " + c.getName();
            }
        }
        if (found) {
            return employeeName + " works at:" + companyNames;
        } else {
            return "Employee not found";
        }
    }

    public Company getCompanyByName(String name) {
        for (int i = 0; i < companies.size(); i++) {
            Company c = companies.get(i);
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

}
