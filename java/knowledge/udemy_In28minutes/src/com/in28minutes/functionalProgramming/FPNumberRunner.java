package com.in28minutes.functionalProgramming;

import java.util.List;

public class FPNumberRunner {
    public static void main(String[] args){
        List<Integer> numbers = List.of(4,6,8,13,3,15);
        System.out.println("totalNumberToForEach");
        totalNumberToForEach(numbers);
        System.out.println("totalNumberToFilter");
        totalNumberToFilter(numbers);
        System.out.println("oddTotalNumber");
        oddTotalNumber(numbers);
    }

    // 총합 구하는 방법 1
    private static void totalNumberToForEach(List<Integer> numbers){
        int total = 0;
        for(Integer number: numbers){
            total += number;
        }
        System.out.println(total);
    }

    // filter를 활용해서 총합 구하기
    private static void totalNumberToFilter(List<Integer> numbers){
        int total = numbers.stream().reduce(0, (number1 ,number2)-> number1 + number2);
        System.out.println(total);
    }

    // odd 총합 구하기
    private static void oddTotalNumber(List<Integer> numbers){
        int total = numbers.stream().filter( element -> element%2 !=0 )
                .reduce(0, (number1, number2) -> number1 + number2);
        System.out.println(total);
    }
}
