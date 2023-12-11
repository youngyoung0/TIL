package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream001 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = new ArrayList<>();

        Optional<Integer> optionalInteger = list.stream()
                .filter(x -> x > 3)
                .filter(x -> x < 9)
                .map(x -> x + 10)
                .filter(x -> x > 15)
                .findFirst();
        System.out.println(optionalInteger.get());
    }
}
