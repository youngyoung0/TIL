package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda002 {

    public static void main(String[] args) {
        System.out.println(getA(10, 20, (x) -> x + x));

        Consumer consumer;
        getB("hi", (x) -> System.out.println(x + x));

        System.out.println(getC(Arrays.asList(1, 2, 3, 4, 5), (x) -> x > 10));

        Long start = System.currentTimeMillis();
        getD1(0, heavyValue());
        getD1(1, heavyValue());
        getD1(1, heavyValue());
        System.out.println("default : " + ((System.currentTimeMillis() - start) / 1000));

        Long start1 = System.currentTimeMillis();
        getD2(0, () -> heavyValue());
        getD2(1, () -> heavyValue());
        getD2(1, () -> heavyValue());
        System.out.println("default : " + ((System.currentTimeMillis() - start1) / 1000));
    }

    // function
    public static Integer getA(int x, int y, Function<Integer, Integer> function) {
        x = x + y;
        return function.apply(x);
    }

    // consumer
    public static void getB(String msg, Consumer<String> consumer) {
        consumer.accept(msg);
    }

    // predicate
    public static boolean getC(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer number : list) {
            if (predicate.test(number)) {
                return true;
            }
        }
        return false;
    }

    // supplier
    private static String heavyValue() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "heavy";
    }

    private static void getD1(int num, String value) {
        if (num == 0) {
            System.out.println("Y" + value);
        } else {
            System.out.println("N");
        }
    }

    private static void getD2(int num, Supplier<String> supplier) {
        if (num == 0) {
            System.out.println("Y" + supplier.get());
        } else {
            System.out.println("N");
        }
    }
}
