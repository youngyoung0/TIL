# Lambda expression (람다 표현식)

### 정의

- 람다는 익명 함수이다.
- 한번 사용되고 재사용되지 않는 함수를 만들대 익명함수를 만듭니다.
- 굳이 함수를 따로 생성하지 않고, 코드 중간에 익명함수를 만들수 있습니다.
- 코드 가독성이 높아지고, 함수형 프로그래밍에서 자주 사용하는 패턴입니다.

### 익명함수 생성

```kotlin
// 익명함수를 생성하여 greeting에 할당
val greeting = fun(){ println("Hello") }
// 익명함수 호출
greeting()
```

```kotlin
// 익명함수를 생성하여 greeting에 할당
val greeting: ()-> Unit = {println("Hello")}
// 익명함수 호출
greeting()
```

### 인자를 받고, 값을 리턴하는 익명함수

```kotlin
fun main(args: Array<String>) {
  // 익명함수를 생성하여 greeting에 할당
  val greeting2 = { name: String, age:String -> "Hello. My name is $name. I'm $age year old" }

  // 익명함수 호출
  val result = greeting2("chacha", "5")
  println(result)
}
```

### 인자 타입을 생략하는 익명함수

```kotlin
fun main(args: Array<String>) {
  // 익명함수를 생성하여 greeting에 할당
  val greeting2: (String, String) -> String = { name, age -> "Hello. My name is $name. i'm $age year old" }

  // 익명함수 호출
  val result = greeting2("chacha", "5")
  println(result)
}
```

### 인자 선언을 생략할 수 있는 익명 함수

```kotlin
val greeting2: (String) -> String = { name -> "Hello. My name is $name."}
val result = greeting2("chacha")

// 인자가 1개일때 생략
val greeting2: (String) -> String = { "Hello. My name is $it."}
val result = greeting2("chacha")

```

### SAM(Single Abstract Method)

추상 메소드에 하나의 메소드만 있는것을 SAM이라고 합니다.

```kotlin
button.setOnClickListener(object : OnClickListener{
  override fun onClick(view: View){
    doSomething()
  }
})
```

람다를 이용하면 구현 코드만 작성하여 인자로 넘겨줄 수 있습니다.

```kotlin
fun setOnClickListener(listener: (View) -> Unit)

button.setOnClickListener({ view -> doSomething() })
```