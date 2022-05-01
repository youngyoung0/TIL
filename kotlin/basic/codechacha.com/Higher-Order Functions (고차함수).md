# Higher-Order Functions (고차함수)

### 정의

함수의 인자로 함수를 넘기거나, 함수를 리턴하는 함수

### 고차함수

returnParamFunc는 함수를 인자로 받고 함수를 결과로 리턴해줍니다.

```kotlin
val hello: () -> String = {"hello world"}

fun returnParamFunc(func: ()->String): () -> String {
    return func
}

fun main(args: Array<String>) {
    val returned = returnParamFunc(hello)
    print("${returned()}")
}
```

### 인자 및 리턴 타입

- 인자로 함수를 넘길때 이름뒤에 :()->String 처럼 함수의 타입을 명시해야 합니다.
- Int를 인자로 받고 String을 리턴하는 함수는 (Int)->String처럼 표현합니다.
- ->의 왼쪽이자, ->의 오른쪽이 리턴갑을 의미합니다.

```kotlin
fun returnParamFunc(func: ()-> String): ()-> {
		return func
}
```