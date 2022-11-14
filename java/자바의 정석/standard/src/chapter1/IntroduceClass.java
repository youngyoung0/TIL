package chapter1;

public class IntroduceClass {
    // example1
    // public class 가 있는 경우, 소스 파일의 이름은 반드시 public class의 이름과 일치패야 한다.
    public class Hello2{}
    class Hello3{}

    // example2
    // public class가 하나도 없는 경우, 소스파일의 이름은 'Hello4.java'. 'Hello5.java' 둘다 가능하다.
    class Hello4{}
    class Hello5{}


    // 잘못된 예
    /* example1
       하나의 소스 파일에 둘 이상의 public class가 존재하면 안된다.
       각 클래스를 별도의 소스파일에 나눠서 저장하던가 아니면 둘 중의 한 클래스에 public 을 붙이지 않아야 한다. */
    public class Hello6{}
    public class Hello7{}

}
