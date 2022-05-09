# Default arguments (기본인자)

### 정의

기본인자는 인자의 값이 default로 설정된다.

JAVA의 경우 동일한 메서드 이름에 인자를 하나 추가하려면, 오버로딩하여 새로운 메서드를 만들어야 한다.

```java
void foo(int bar) {}
void foo(int bar, int baz) {}

foo(1);
foo(1,2);
```

Kotlin은 기본 인자를 지원하기 때문에 1개의 메서드만 정의하여 위의 두가지 함수 호출을 가능하게 할수 있다.

```kotlin
fun foo(bar, baz: Int = 0)

foo(1) // baz =0은 기본인자로 전달
foo(1,2)
```

### 규칙

인자를 생략하는 방법에 따라서 메서드를 호출할때 어떤인자를 생략할 수 있는지 정해진다.

```kotlin
fun foo(qux: () -> Unit, bar: Int = 0, baz: Int = 1){
	println("bar: $bar")
	println("baz: $baz")
	qux()
}

// 함수를 호출할때 매번 인자 앞에 이름을 명시해 주는 방법
foo(bar = 2, baz = 1, qux = { println("hello")}

// 인자의 이름을 명시적으로 지정하지 않고 일부 인자를 생략한다면, 코틀린 규칙에 의해서 기본 인자가 적용된다.
foo({println("hello")})
foo({println("hello"),1})
foo({println("hello"),1,2})
```

기본인자가 왼쪽으로 오고, 인자가 오르쪽일 경우는 

```kotlin
fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit){
	println("bar: $bar")
	println("baz: $baz")
	qux()
}

// 명시하지않은 두번째 인자가 baz가 생략되어서 기본 인자로 전달 됩니다.
foo(1, qux={println("hello")}) // baz = 1
```