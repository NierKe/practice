package com.dk.equals;

public class StudentVO {
    int id;
    int age;
    String sex;
    StudentVO classMate;
    Father father;
    public StudentVO getClassMate() {
        return classMate;
    }

    public int getId() {
        return id;
    }

    public static Integer num ;
    static {
        num = 123;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", classMate=" + classMate +
                ", father=" + father +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClassMate(StudentVO classMate) {
        this.classMate = classMate;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public StudentVO() {
    }

    public StudentVO(int id,int age, String sex, StudentVO classMate, Father father, String name) {
        this.age = age;
        this.sex = sex;
        this.classMate = classMate;
        this.father = father;
        this.name = name;
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

}
