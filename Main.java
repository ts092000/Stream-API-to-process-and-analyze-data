package com.bkitsolution;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Person p01 = new Person("Paul", 25);
        Person p02 = new Person("Sarah", 27);
        Person p03 = new Person("James", 31);
        Person p04 = new Person("Julie", 25);
        Person p05 = new Person("Charles", 22);
        Person p06 = new Person("Charlotte", 31);
        Person p07 = new Person("Ann", 27);
        Person p08 = new Person("Boris", 29);
        Person p09 = new Person("Emily", 34);
        Person p10 = new Person("", 34);

        //Flat Mapping
        City newYork = new City("New York", p01, p02, p03);
        City paris = new City("New York", p04, p05, p06);
        City london = new City("New York", p07, p08, p09);

        List<City> cities = List.of(newYork, paris, london);

        long count = cities
                .stream()
                .flatMap(city -> city.getPeople().stream())
                .count();

        System.out.println("Count = " + count);

        cities.stream()
                .flatMap(city -> city.getPeople().stream())
                .forEach(System.out::println);

        cities.stream()
                .flatMap(city -> city.getPeople().stream())
                .map(Person::getName)
                .forEach(System.out::println);


//        List<Person> people = List.of(p01, p02, p03, p04, p05, p06, p07, p08, p09, p10);
//
//        long countEmptyNames = people
//                .stream()
//                .map(Person::getName)
//                .filter(String::isEmpty)
//                .count();
//
//        Stream<Person> stream = people.stream();
//        Stream<String> nameStream = stream.map(p -> p.getName());
//        Stream<String> filterdName = nameStream.filter(name -> name.isEmpty());
//        long count = filterdName.count();
//
//        Stream<Person> stream2 = people.stream();
//        Stream<String> nameStream2 = stream2.map(p -> p.getName());
//        Stream<String> filterdName2 = nameStream2.filter(name -> !name.isEmpty());
//        long count2 = filterdName2.count();
//
//        System.out.println("Empty names = " + count);
//        System.out.println("Empty names = " + countEmptyNames);
//        System.out.println("Non empty names = " + count2);

    }
}
