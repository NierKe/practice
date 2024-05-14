package com.dk.reflection;

import java.io.Serializable;

public class People implements Cloneable, Serializable {

    private  static final String sys = "1231232FFFF";
    public String name;
    public int age;
    public String sex;
    private String ID;
    public String pk = "1231fff";
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public People() {

    }

    public People(String name, int age, String sex, String ID) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.ID = ID;
    }

    public People clone() throws CloneNotSupportedException {
        return (People) super.clone();
    }

    public void output(){
        System.out.println("哈哈哈");
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
