package com.bkitsolution;

import java.util.List;
import java.util.Optional;

public class SimpleReduction {

    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 1, 1, 1, 1);
        List<Integer> intsEmpty = List.of();
//        List<Integer> ints = List.of(); List empty: reduce = Optional.empty

//        Optional<Integer> reduce = ints.stream().reduce((i1, i2) -> i1 + i2);
//        int sum = ints.stream().reduce(0, Integer::sum);
        int sum = ints.stream().reduce(0, (i1, i2) -> i1 + i2);
        int sum2 = intsEmpty.stream().reduce(0, (i1, i2) -> i1 + i2);

        System.out.println("Sum = " + sum);
        System.out.println("Empty List sum = " + sum2);

//        System.out.println("Reduce = " + reduce);
//
//        reduce.get();
//        Integer sum = reduce.orElseThrow();
//        System.out.println("sum = " + sum);
    }
}
