package com.bkitsolution;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class AvarageAge {
    public static void main(String[] args) {
        Person p01 = new Person("Paul", 12);
        Person p02 = new Person("Sarah", 27);
        Person p03 = new Person("James", 31);
        Person p04 = new Person("Julie", 15);
        Person p05 = new Person("Charles", 22);

        List<Person> people = List.of(p01, p02, p03, p04, p05);

//        int sum = 0;
//        int count = 0;

        double average = people.stream()
                .mapToInt(Person::getAge)
                .filter(age -> age > 20)
                .average()
                .orElseThrow();

        System.out.println("Average = " + average);
//
//        for (Person person : people) {
//            if (person.getAge() > 20) {
//                count++;
//                sum += person.getAge();
//                System.out.println(person);
//            }
//        }
//
//        System.out.println("Count = " + count);
//
//        double average = 0d;
//        if (count > 0) {
//            average = sum / count;
//        }
//        System.out.println("Average = sum / count = " + average);
    }
}
