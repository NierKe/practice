package com.dk.design.celue.po;

public class Employee {
    private String name;
    private int level;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }

    public Employee(String name, int level) {
        this.name = name;
        this.level = level;
    }
    //sdsd
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
