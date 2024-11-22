package com.dk.steam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 23),
                new Person("Bob", 25),
                new Person("Charlie", 23)
        );

        Map<Integer, List<Person>> groupedByAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        Map<Integer, List<String>> collect = persons.stream().collect(Collectors.groupingBy(
                Person::getAge,
                Collectors.mapping(Person::getName, Collectors.toList())
        ));
        Map<Integer, Long> countByAge = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.counting()
                ));
       // NavigableMap<Integer, List<Person>> integerListNavigableMap = persons.stream().collect(Collectors.groupingBy(Person::getAge, TreeMap::new, Collectors.toList())).descendingMap();


        System.out.println(countByAge);

        System.out.println(collect);

    }
}
