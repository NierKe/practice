package com.dk.localdate;

import com.dk.thissuper.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate of = LocalDate.of(2024, 9, 30);
        System.out.println(of);
        LocalDate localDate = of.plusWeeks(1);
        System.out.println(localDate);
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);

        Student vo = new Student("dongke",45,null);
        Student vo2 = new Student("dongke",45,"清华大学");

        Optional.ofNullable(vo)
                .map(Student::getSchool)
                .filter(x->x.equals("ss"))
                .ifPresent(System.out::println);

        String s = Optional.of(vo)
                .map(Student::getSchool)
                .orElseGet(vo2::getSchool);
        System.out.println(s);
    }
}
