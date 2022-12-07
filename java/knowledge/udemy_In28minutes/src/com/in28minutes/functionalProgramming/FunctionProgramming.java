package com.in28minutes.functionalProgramming;

import java.util.List;

public class FunctionProgramming {
    public static void main (String[] args){
        List<String> list = List.of("Apple", "Bat", "Cat", "DOG");
        List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9);
        List<Integer> mishmashNumberList = List.of(3,5,8,213,45,4,7);
        List<Integer> distinctNumberList = List.of(3,5,3,5,213,45,4,7);


//        System.out.println("printBasicWithFiltering");
//        printBasicWithFiltering(list);
//        System.out.println("printWithFP");
//        printWithFP(list);
//        System.out.println("printWithFPWithFiltering");
//        printWithFPWithFiltering(list);
//        System.out.println("printOddNumber");
//        printOddNumber(numberList);
//        System.out.println("printEvenNumber");
//        printEvenNumber(numberList);
//        System.out.println("fpSum");
//        System.out.println(fpSum(numberList));
        System.out.println("fpSort");
        fpSort(mishmashNumberList);
        System.out.println("fpdDistinct");
        fpdDistinct(distinctNumberList);
        System.out.println("fpMap");
        fpMap(distinctNumberList);
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

    // 람다 모든 수 덧셈
    private static int fpSum(List<Integer> numbers){
        return numbers.stream().reduce(0,
                (number1, number2)->  number1 + number2);
    }

    // 람다 정렬
    private static void fpSort(List<Integer> numbers){
        numbers.stream().sorted().forEach(
                number -> System.out.println(number)
        );
    }

    // 람다 중복 제거
    private static void fpdDistinct(List<Integer> numbers){
        numbers.stream().distinct().sorted().forEach(
                number -> System.out.println(number)
        );
    }

    // map
    private static  void fpMap(List<Integer>numbers){
        numbers.stream().distinct().map(number -> number * number).forEach(number -> System.out.println(number));
    }

}
