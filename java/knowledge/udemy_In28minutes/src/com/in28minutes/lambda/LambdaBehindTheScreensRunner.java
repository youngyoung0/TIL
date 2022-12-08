package com.in28minutes.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EvenNumberPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }
}

class SystemOutConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer number) {
        System.out.println(number);
    }
}

class NumberSquareMapper implements Function<Integer, Integer>{

    @Override
    public Integer apply(Integer integer) {
        return integer * integer;
    }
}

public class LambdaBehindTheScreensRunner {

    public static void main(String[] args){

        // 1.
        List.of(23,43,34,45).stream()
                .filter(n -> n%2 == 0)
                .map(n -> n * n)
                .forEach(n -> System.out.println(n));

        List.of(23,43,34,45).stream()
                .filter(new EvenNumberPredicate())
                .map(new NumberSquareMapper())
                .forEach(new SystemOutConsumer());
        // .map
        //  R apply(T t);
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);

        // .filter
        // Stream<T> filter(Predicate<? super T> predicate);
        // boolean test(T t);

        // .forEach
        // void forEach(Consumer<? super T> action);
        // void accept(T t);

        System.out.println("-----------------");
        // 2.
        // 변수에 함수를 저장
        // 함수를 메소드로 전달
        // 메서드에서 함수를 반환
        Predicate<? super Integer> evenPredicate = createEvenPredicate();
        Predicate<? super Integer> oddPredicate = number -> number % 2 == 1;
        Function<? super Integer, ?> squareFunction = number -> number * number;
        Consumer<?> systemConsumer = System.out::println;

        List.of(23,43,34,45).stream()
                .filter(evenPredicate)
                .map(n -> n * n)
                .forEach(System.out::println);

    }
    private static Predicate<? super Integer> createEvenPredicate(){
        return  n -> n % 2 == 0;
    }
}
