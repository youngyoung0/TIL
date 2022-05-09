# Closure (클로저)

### 정의

closure는 outer scope(상위 함수의 영역)의 변수를 접근할 수 있는 함수를 말합니다.

코틀린은 클로저를 지원하며 그렇기 때문에 익명함수는 함수 밖에서 정의된 변수에 접근할 수 있다.

```kotlin
fun add(x: Int): (Int) -> Int{
	return fun(y: Int): Int{
		return x + y
	}
}

fun main(args: Array<String>) {
	val func = add(10)
	val result = func(20)
	println(result)
}
```

add 함수는 익명함수를 리턴합니다. x는 전역변수도, 익명함수의 인자도 아니고 내부에서 정의하지 않았기 때문에 익명함수는 변수 x에 접근할수 없지만 코틀린에서 클로저를 지원하기 때문에 컴파일 에러가 발생하지 않습니다.

함수 밖에 정의된 변수들을 사용할 수 있는 함수를 클로저라고 합니다.

### 클로저 예제

forEach함수는 익명함수를 인자로 받습니다. 람다식으로 생성한 익명함수도 클로저 함수이며, outer scope의 변수에 접근할 수 있습니다.

```kotlin
var sum = 0
var ints = mutableListOf(1,2,3)
ints.filter {it>0}.forEach{
	sum += it
}
print(sum)
```

java

```java
function add(x) {
    return function closure(y) {
        return x + y;
    };
}
```