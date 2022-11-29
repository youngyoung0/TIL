package com.in28minutes.functionalProgramming;

import java.util.List;

public class FunctionProgramming {
    public static void main (String[] args){
        List<String> list = List.of("Apple", "Bat", "Cat", "DOG");
        List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9);


        System.out.println("printBasicWithFiltering");
        printBasicWithFiltering(list);
        System.out.println("printWithFP");
        printWithFP(list);
        System.out.println("printWithFPWithFiltering");
        printWithFPWithFiltering(list);
        System.out.println("printOddNumber");
        printOddNumber(numberList);
        System.out.println("printEvenNumber");
        printEvenNumber(numberList);

    }

    private static void printBasic(List<String> list){
        for(String word: list){
            System.out.println(word);
        }
    }

    private static void printBasicWithFiltering(
            List<String> list
    ){
        for(String word: list){
            if(word.endsWith("at")){
                System.out.println(word);
            }
        }
    }

    private static void printWithFP(List<String> list){
        list.stream().forEach(element -> System.out.println("element - " + element));
    }

    private static void printWithFPWithFiltering(List<String> list){
        list.stream().filter(element -> element.endsWith("at"))
                .forEach(
                        element -> System.out.println("element - " + element)
                );
    }

    private static void printOddNumber(List<Integer> numberList){
        numberList.stream().filter(element -> element%2 != 0)
                .forEach(
                        element -> System.out.println(element)
                );
    }

    private static void printEvenNumber(List<Integer> numberList){
        numberList.stream().filter(element -> element %2 == 0)
                .forEach(
                        element -> System.out.println(element)
                );
    }
}
