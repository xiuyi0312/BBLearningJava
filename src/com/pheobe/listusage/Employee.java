package com.pheobe.listusage;

public class Employee {
    private String name;
    private String position;
    private String registry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    @Override
    public String toString() {
        return name + ", " + position;
    }

    public boolean equals(Employee other) {
        return name.equals(other.getName());
//        return registry.equals(other.getRegistry());
    }
}
