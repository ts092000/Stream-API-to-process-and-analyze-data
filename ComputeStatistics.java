package com.bkitsolution;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Function<String, String> lineToName =
                line -> line.split(";")[1];

        Path path = Path.of("data/cities.csv");
        Set<String> cities = null;
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

            cities = lines.skip(2)
                    .map(lineToName)
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("# cities = " + cities.size());

        List<String> citiesWithA = cities.stream()
                .filter(city -> city.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Cities with 'A': " + citiesWithA);

//        String[] array = cities.toArray(String[]::new);
        String[] array = cities.stream().toArray(String[]::new);
        System.out.println("# array = " + array.length);

        String joined = cities.stream()
                .filter(name -> name.length() == 4)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joined);

        String collect = Stream.<String>empty()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Collecting an empty stream: " + collect);
    }
}
