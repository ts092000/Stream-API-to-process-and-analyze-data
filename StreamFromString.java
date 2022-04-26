package com.bkitsolution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamFromString {
    public static void main(String[] args) {
        String sentence = "the quick brown fox jumps over the lazy dog";
        sentence.chars()
                .mapToObj(Character::toString)
                .filter(letter -> !letter.equals(" "))
                .distinct()
                .sorted()
                .forEach(System.out::print);

    }
}
