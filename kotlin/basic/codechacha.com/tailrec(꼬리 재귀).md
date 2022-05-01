# tailrec(꼬리 재귀)

### 정의

tailrec은 꼬리재귀(tail recursive)라는 의미로 추가적인 연산없이 자신 스스로 재귀적으로 호출하다가 어떤 값을 리턴하는 함수를 의미합니다.

자신만을 반복적으로 호출하는 재귀함수(tailrec)는 while과 같은 루프를 사용하는 코드로 변환이 가능하다.

- 이렇게 변환하면 좋은점 → 재귀함수가 호출되면서 소비되는 스택을 아낄수 있다.

### 예시

### 꼬리재귀

factorial은 재귀함수로 구현되었고, 재귀함수가 스스로 자신만을 호출하다 값을 리턴하는 구조이기 때문에 꼬리재귀(trailrec)라고 할 수 있습니다.

```kotlin
fun main(args: Array<String>) {
	println("factorial(10): ${factorial(10,1)}")
}

fun factorial(n: Int, acc: Int): Int{
	return if (n<=0){
		acc
	}else{
		factorial(n-1, n * acc)
	}
}
// return factorial(10): 3628800
```

### 재귀함수

자신만을 반복적으로 호출하지 않고 1 + 재귀함수와 같은 추가적인 연산을 수행합니다.

그렇기 때문에 꼬리 재귀함수가 압니다.

```kotlin
fun main(args: Array<String>) {
	println("factorial_plus_n(10) ${factorial_plus_n(10, 1)}")
}
fun factorial_plus_n(n: Int, acc: Int): Int{
	return if(n<= 0){
		acc
	}else{
		1 + factorial_plus_n(n-1, n*acc)
	}
}
// return factorial_plus(10) 3628810
```

### tailrec 사용 방법

꼬리재귀인 factorial함수에 trailrec이라는 키워드를 붙이면 컴파일러가 꼬리재귀를 루프를 이용한 코드로 변경해줍니다.

```kotlin
tailrec fun factorial(n: Int, acc: Int): Int{
	return if (n<=0){
		acc
	}else{
		factorial(n-1, n * acc)
	}
}
```

꼬리재귀가 아닌 함수에 tailrec키워드를 붙여도, 루프 코드로 변경되지 않습니다.

```kotlin
tailrec fun factorial_plus_n(n: Int, acc: Int): Int{
	return if(n<= 0){
		acc
	}else{
		1 + factorial_plus_n(n-1, n*acc)
	}
}
// Warning:(11, 1) Kotlin: A function is marked as tail-recursive but no tail calls are found
```

일반 재귀함수에 tailrec이 붙은 코드를 컴파일을 해보면 tailrec 키워드가 붙었지만 꼬리재귀가 아니라는 경고 발생합니다.

### 정리

꼬리재귀(tail recursive)와 재귀함수의 차이점

- 꼬리 재귀는 결국 반복문 실행이기 때문에 일반 재귀 함수에서 발생하는 스택 오버 플로우나 성능저하가 발생하지 않는다.
재귀의 탈을 쓰고 있는 반복문이기에 가독성과 성능 모두 만족시킨다.
하지만 컴파일러에서 최적화 해주지않는다면, 꼬리 재귀자체의 이점은 사라진다.
- 성능만 본다며 재귀함수는 사용하지 않는게 맞다. 
반복문으로 구현했을때 보다 메모리나 속도 등 성능적인 측면에서 많이 뒤쳐지기 때문이다.

tailrec키워드가 꼬리재귀를 자원소비가 적은 루프 코드로 컴파일하는것을 도와줍니다.