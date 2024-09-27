package com.dk.thissuper;

import java.util.Date;

public class Person {
    public Person(){};
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private int age;
    private Date birthDate;
    public Person(String name, int age, Date d) {
       this.name = name;
       this.age = age;
       this.birthDate = d; }
    public Person(String name, int age) {
       this(name, age, null);
    }
    public Person(String name, Date d) {
       this(name, 30, d);
    }
    public Person(String name) {
       this(name, 30);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
