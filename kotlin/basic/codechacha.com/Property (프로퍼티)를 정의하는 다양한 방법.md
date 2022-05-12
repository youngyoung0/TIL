# Property (프로퍼티)를 정의하는 다양한 방법

코틀린에서 클래스에 val/var로 정의되는 변수를 프로퍼티라고 합니다.

프로퍼티를 생성하면 getter와 setter가 자동으로 생성됩니다.

```kotlin
class Person() {
  val name = "chacha"
  var age = 10
  var isStudent = false
}

fun main(args: Array<String>) {
  val person = Person()
  println(person.name) // chacha
  println(person.age) // 10
  person.age = 20
  if (person.isStudent) {
  }
}
```

코틀린에서 프로퍼티를 정의하면 getter / setter 함수를 만들지 않고 그냥 직접 접근하여 사용하면 됩니다. 하지만 실제로 직접 접근하지는 않습니다. get / set 메소드로 객체의 변수에 접근합니다.

코틀린의 프로퍼티 getter / setter 생성하는 규칙

- val은 불변(immutable) 이기 때문에 getter만 생성됩니다.
- var은 변하기(mutable)  때문에 setter / getter가 모두 생성됩니다.
- getter의 이름은 get + 변수이름 / setter의 이름은 set + 변수이름
- isStudent처럼 변수에 is가 붙는다면 is를 제거한 get (set) + 변수이름
- private변수는 getter / setter가 생성되지 않습니다.

### 커스텀 getter, setter 만들기

프로퍼티를 정의하면 setter / getter가 생성되지만, 변수에 값을 변경하거나 리턴만 합니다. 다른 계산을 하거나 로그를 출력하는 코드를 넣을 수 없습니다.

디테일한 작업을 추가하려면 프로퍼티에 get(), set()함수를 정의해주어야 합니다.

```kotlin
class Rectangle {
    var width = 10
        set(value) {
            field = value / 2
        }
    var height = 10
        set(value) {
            field = value / 2
        }
    var area: Int = 0
        get() = width * height
}

// 위의 객체는 이렇게 사용할 수 있습니다.
fun main(args: Array<String>) {
    val rect = Rectangle()
    println("width: ${rect.width}") // 10
    println("height: ${rect.height}") // 10
    println("area: ${rect.area}") // 100

    rect.width = 40
    rect.height = 40
    println("width: ${rect.width}") // 20
    println("height: ${rect.height}") // 20
    println("area: ${rect.area}") //400
}
```

- var width = 10는 프로퍼티의 초기값을 정의하는 코드입니다.
- set(value)에서 value는 인자를 의미합니다.
- field = value는 프로퍼티에 값을 설정하는 코드입니다. → width = value는 사용하면 안됩니다.
- var area: Int = 0 는 프로퍼티 초기값을 정의하는 코드입니다.
- get() {... return 값} 은 구현 및 값을 리턴하는 코드입니다.
- get() = ... 처럼 한줄로 함수를정의할 수도 있습니다.

✔︎ get() 과 set()을 동시에 정의할 수도 있습니다.

### Private setter 만들기

외부에서 변수를 변경하지 못하도록 할 수 있습니다.

set()을 private으로 선언하면 됩니다. 그럼 private setter가 생성되어 내부에서만 설정할 수 있게 됩니다.

```kotlin
class Rectangle {
    var width = 10
        private set(value) {
            field = value / 2
        }
    var height = 10
        private set(value) {
            field = value / 2
        }
    var area: Int = 0
        get() = width * height
}

val rect = Rectangle()
```