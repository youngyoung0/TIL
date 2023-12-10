package lambda;

@FunctionalInterface
interface Mathematics {
    int calculate(int x, int y);
}

// return 타입이 없는 lambda
@FunctionalInterface
interface Trace<T>{
    void follow(T t);
}

@FunctionalInterface
interface Trace2 {
    void follow2();
}



public class Lambda001 {

    public static void main(String[] args) {
        // f(x,y - (x+y) --> (x,y) -> x+y
        // 추상 메소드 하나인 인터페이스를 가지고

        Mathematics mathematics1 = (x, y) -> {return x + y;};
        Mathematics mathematics2 = (x, y) -> x + y;

        System.out.println(cal(2,2, mathematics1));
        System.out.println(cal(2,2, (x, y) -> x + y));

        Trace<String> trace = (x) -> {
            System.out.println(x + " " +System.currentTimeMillis());
        };

        trace.follow("PSC");

        Trace2 trace2 = () -> System.out.println("Hello");
        trace2.follow2();
    }

    public static int cal(int x, int y, Mathematics mathematics){
        return mathematics.calculate(x, y);
    }
}
