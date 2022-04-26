package com.bkitsolution;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bkitsolution.City;

public class ComputeStatistics {
    public static void main(String[] args) {

//        String lineForNewYork = "1;New York; New York;8 336 817;780,9";
//        ToDoubleFunction<String> lineToDensity = line -> {
//            String[] split = line.split(";");
//
//            String populationAsString = split[3];
//            populationAsString = populationAsString.replace(" ", "");
//            int population = Integer.parseInt(populationAsString);
//
//            String landAreaAsString = split[4];
//            landAreaAsString = landAreaAsString.replace(" ", "").replace(',', '.');
//            double landArea = Double.parseDouble(landAreaAsString);
//
//            return population / landArea;
//        };

//        double density = lineToDensity.applyAsDouble(lineForNewYork);
//        System.out.println("Density of New York = " + density);
//        Function<String, String> lineToName =
//                line -> line.split(";")[1];
        Function<String, City> lineToCity = line -> {
            String[] split = line.split(";");

            String cityName = split[1].trim();

            String state = split[2].trim();

            String populationAsString = split[3];
            populationAsString = populationAsString.replace(" ", "");
            int population = Integer.parseInt(populationAsString);

            String landAreaAsString = split[4];
            landAreaAsString = landAreaAsString.replace(" ", "").replace(',', '.');
            double landArea = Double.parseDouble(landAreaAsString);

            return new City(cityName, state, population, landArea);
        };

        Path path = Path.of("data/cities.csv");
        Set<City> cities = null;
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1);) {

//            double min = lines.skip(2)
//                    .map(lineToDensity::apply)
//                    .min(Comparator.naturalOrder())
//                    .orElseThrow();

//            double max = lines.skip(2)
//                    .mapToDouble(lineToDensity)
//                    .max()
//                    .orElseThrow();

//            DoubleSummaryStatistics summaryStatistics = lines.skip(2)
//                    .mapToDouble(lineToDensity)
//                    .summaryStatistics();

//            System.out.println("Min = " + min);
//            System.out.println("Max = " + max);
//            System.out.println("Stats = " + summaryStatistics);

//            cities = lines.skip(2)
//                    .map(lineToName)
//                    .collect(Collectors.toSet());

            cities = lines.skip(2)
                    .map(lineToCity)
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println("# cities = " + cities.size());
//
//        List<String> citiesWithA = cities.stream()
//                .filter(city -> city.startsWith("A"))
//                .collect(Collectors.toList());
//        System.out.println("Cities with 'A': " + citiesWithA);

//        String[] array = cities.toArray(String[]::new);
//        String[] array = cities.stream().toArray(String[]::new);
//        System.out.println("# array = " + array.length);
//
//        String joined = cities.stream()
//                .filter(name -> name.length() == 4)
//                .collect(Collectors.joining(", ", "[", "]"));
//        System.out.println(joined);
//
//        String collect = Stream.<String>empty()
//                .collect(Collectors.joining(", ", "[", "]"));
//        System.out.println("Collecting an empty stream: " + collect);

        System.out.println("# cities = " + cities.size());

        Map<String, List<City>> citiesPerState =
                cities.stream().collect(Collectors.groupingBy(city -> city.getState()));

        System.out.println("Map size = " + citiesPerState.size());

        List<City> citiesOfUtah = citiesPerState.get("Utah");
        System.out.println(citiesOfUtah);

        Map<String, Long> numberOfCitiesPerState =
                cities.stream()
                .collect(Collectors.groupingBy(city -> city.getState(), Collectors.counting()));

        System.out.println("# cities in Utah: " + numberOfCitiesPerState.get("Utah"));

        Map.Entry<String, Long> stateWithMostCites = numberOfCitiesPerState
                .entrySet().stream()//Stream Map.Entry<String, Long>
//                .max(Comparator.comparing(Map.Entry::getValue))
                .max(Map.Entry.comparingByValue()).orElseThrow();

        System.out.println("State with most cities: " + stateWithMostCites);

//        int populationOfUtah = citiesPerState.get("Utah").stream()
//                .mapToInt(city -> city.getPopulation())
//                .sum();
//                .collect(Collectors.summingInt(city -> city.getPopulation()));
//        System.out.println(populationOfUtah);

        Map<String, Integer> populationOfCitiesPerState =
                cities.stream()
                        .collect(Collectors.groupingBy(city -> city.getState(),
                                Collectors.summingInt(city -> city.getPopulation())));

        System.out.println("Population of Utah = " + populationOfCitiesPerState.get("Utah"));

        Map.Entry<String, Integer> stateWithTheMostPeople =
                populationOfCitiesPerState.entrySet().stream() // Stream Map.Entry<String, Integer>
                        // .max(Comparator.comparing(Entry::getValue))
                        .max(Map.Entry.comparingByValue())
                        .orElseThrow();

        System.out.println(stateWithTheMostPeople);
    }
}
