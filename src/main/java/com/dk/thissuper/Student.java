package com.dk.thissuper;

public class Student extends Person {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student(String name, int age, String s) {
      super(name, age);
      school = s;
    }

    public Student(String name, String s) {
      super(name);
      school = s; 
    }
// 编译出错: no super(),系统将调用父类无参数的构造器。
    public Student(String s) {
      school = s;
    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                '}';
    }
}
