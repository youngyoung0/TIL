# companion object로 static 메소드, 객체 정의하기

### 정의

자바는 static 키워드를 클래스 내부 static 변수, 메소드를 정의할 수 있다.

외부에서 접근하려면은 객체를 생성한후에 접근하는 방법이 있다.

하지만 kotlin에서는 static 키워드를 제공하지 않는다. 대신 Companion 기능을 제공한다.

```kotlin
class MyClass{
	companion object{
		val TAG = "MyClass"
		fun createFiles(){
		}
	}
}

/*
	외부에서 접근 방법
	MyClass.TAG
	MyClass.Companion.TAG
	MyClass.createFiles()
	MyClass.Companion.createFiles()
*/
```

### 자바에서 코틀린의 companion 호출하기

```kotlin
class MyClass{
	companion object{
		const val TAG = "MyCLass"
		@JvmStatic fun createFiles(){
		}
	}
}
```

@JvmStatic

- 클래스의 바로 밑에 정정 메소드 생서
- Companion 내부에도 객체를 생성

→ 자바에서 MyClass.createFiles와 MyClass.Companion.createfiles 모두 사용 가능합니다.

const 또는 @JvmFieId

- TAG 앞에 const를 붙힌 대신 @JvmFieId를 붙여도 동일하게 처리됩니다.
- companion의 필드에 어노테이션이 붙이면, 클래스 바로 밑에 정적 객체가 정의됩니다.