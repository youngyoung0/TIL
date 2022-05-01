# First-class functions (일급함수)

### 정의

- 객체로 취급될 수 있다.
- 객체를 인자로 넘길 수 있어야 한다.
- 함수 객체를 인자로 넘길 수 있어야 합니다.

### 일급함수는 함수가 객체로 취급될 수 있다.

```kotlin
val hello: () -> String = {"hello world"}
```

### 일급함수는 함수 객체를 인자로 넘길 수 있어야 한다.

```kotlin
val hello: () -> String = {"hello world"}
fun printHello(func: ()->String) {
    print("${func()}")
}

fun main(args: Array<String>) {
    printHello(hello)
}
```

### 일급함수는 함수 객체를 함수의 결과로 리턴할 수 있습니다.

```kotlin
val hello: () -> String = {"hello world"}
fun returnHello(): () -> String {
    return hello
}

fun main(args: Array<String>) {
    val returned: ()->String = returnParamFunc(hello)
    print("${returned()}")
}
```