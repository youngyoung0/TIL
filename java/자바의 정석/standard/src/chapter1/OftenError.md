## 자주 발생하는 에러와 해결방법

1. cannot find symbol 또는 cannot resolve symbol
   - 지정된 변수나 메서드를 찾을 수 없다는 뜻으로 선언되지 않은 변수나 메서드를 사용
   - 변수 또는 메서드의 이름을 잘못 사용한 경우에 발생
2. ';' expected
   - 자바의 모든 문장의 끝에는 ';'을 붙여주어야 한다.
3. Exception in thread "main" java.lang.NoSuchMethodError: main
   - 'main' 메서드를 찾을 수 없다.
   - 클래스 내에 main메서드가 존재하지 않는다.
4. Exception in thread "main" java.lang.NoClassDefFoundError: Hello
   - Hello라는 클래스를 찾을 수 없다.
   - 클래스파일이 존재하는데도 동일한 메세지가 반복해서 나타난다면 클래스 패스의 설정이 바르게 되어있는지 확인
5. illegal start of expression
   - 문장의 앞부분의 문법에 맞지 않는다는 뜻
   - 문장에 문법적 오류가 있다. > '{', '(' 열고서 닫지 않은 경우
6. class, interface, or enum expected
   - 키워드 class나 interface 또는 enum이 없다
   - 보통 괄호'{' 또는 '}'의 개수가 일치 하지 않는경우에 발생한다.

## 에러가 발생했을때, 어떻게 해결할 것인가에 대한 방법
1. 에러메세지를 잘 읽고 해당 부분의 코드를 살펴본다. 이상이 없으면 해당 코드의 주위도 살펴본다.
2. 그래도 이상이 없으면 에러 메세지는 잊어버리고 기본적이 부분을 재확인한다.
3. 의심이 가는 부분을 주석처리하거나 따로 떼어내서 테스트 한다.

✓ 대부분의 경우 에러 메세지만 잘 이해해도 문제가 해결되는 경우가 많으므로 에러 해결을 위해서 제일 먼저 해야 할 일은 메세지를 잘 읽는 것이다.