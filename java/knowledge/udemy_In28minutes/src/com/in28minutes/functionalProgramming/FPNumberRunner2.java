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

        System.out.println(IntStream.range(1,11).reduce(0, (n1, n2) -> n1 + n2 ));

        // max
        System.out.println(List.of(23,12,34,53).stream().max((n1, n2 )-> Integer.compare(n1, n2)).get());
    }
}
