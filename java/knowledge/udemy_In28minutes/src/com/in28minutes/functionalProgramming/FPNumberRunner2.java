package com.in28minutes.functionalProgramming;

import java.util.List;
import java.util.stream.IntStream;

public class FPNumberRunner2 {
    public static void main(String[] args){
        // print squares of first 10 numbers!
        IntStream.range(1, 10).map(e -> e * e).forEach(e-> System.out.println(e));

        // map all of these to lowercase and print them
        List.of("Apple", "Ant","Bat").stream().map(e -> e.toLowerCase()).forEach(e -> System.out.println(e));

        // print the length of each element
        List.of("Apple", "Ant", "Bat").stream().map(e -> e.length()).forEach(e -> System.out.println(e));
    }
}
