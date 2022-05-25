# Set Collection

### Set Collection에 대한 학습

```java
public class Test {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
...
```

### 요구사항1

• Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.

```java
@DisplayName("set 사이즈를 확인하는 테스트 코드입니다.")
@Test
void setSeizeConfirm(){
    assertThat(numbers.size()).isEqualTo(3);
}
```

### 요구사항2

- Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

```java
@DisplayName("set안에 1,2,3값이 있는지 확인")
@Test
void setContains(){
    assertThat(numbers.contains(1));
    assertThat(numbers.contains(2));
    assertThat(numbers.contains(3));
}
```

→ 중복코드 제거

```java
@ParameterizedTest
@ValueSource(ints = {1,2,3})
void setNumbersParameterizedTest(int input){
    assertTrue(numbers.contains(input));
z}
```

- 여러 argument를 이용해 테스트를 여러번 돌릴 수 있는 테스트를 할 수 있는 기능
- 사용하기 위해서는 @Test 대신 @ParameterizedTest를 붙이면 된다.
- @ParameterizedTest를 사용하게 되면 최소 하나의 source 어노테이션을 붙여주어야 한다.

### 요구사항3

- 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

```java
@ParameterizedTest
@CsvSource(value={"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
void csvSourceTest(int input, boolean expected){
    assertEquals(numbers.contains(input),expected);
}
```

- CsvSource의 value 속성으로 다음과 같이 파라미터를 던질 수 있다.
- 이렇게 문자열로 구분자 “ , ”를 기준으로 값을 잘라서 파라미터에 담아준다.
- 모든 문자는 String으로 주의하도록 한다.
- @CsvSource 어노테이션에 delimiter을 직접 정의함으로써 구분자를 지정할수 있다.

### Assertj 활용

• [Introduction to AssertJ](https://www.baeldung.com/introduction-to-assertj) 문서 참고해 assertj의 다양한 활용법 익힌다.