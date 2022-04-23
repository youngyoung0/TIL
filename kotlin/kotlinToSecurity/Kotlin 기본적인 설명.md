# Kotlin 기본적인 설명

### Kotlin 설명

- NullSafe,?.let(), ?.run()
    - NullSafe로 인해서 생산성이 올라간다.
        
        ```kotlin
        fun main(args: Array<String>) {
        	var message: Text? = null
        	println(message?.text)
        }
        
        data class Text(
        	var text: String = "Hello world!!"
        )
        ```
        
        console → null
        
    - ?.let{}
        
        ```kotlin
        fun main(args: Array<String>) {
        	var message: Text? = null
        	message?.let {
        		println(it.text)
        	}
        }
        
        data class Text(
        	var text: String = "Hello world!!"
        )
        ```
        
        ✔︎ Nullabel객체를 다른 Nullable객체로 변환하는 경우
        
        ✔︎ 단일 지역 변수의 범위를 제한하는경우
        
        ✖︎ Null check 여부로만 사용하려면 ?.run를 사용
        
        ```kotlin
        fun main(args: Array<String>) {
        	var message: Text? = null
        	message?.run {
        		println(it.text)
        	}
        }
        
        data class Text(
        	var text: String = "Hello world!!"
        )
        ```
        
- var, val
    - var
        - 초기화 후 값을 변경이 가능합니다.
        - 이미 정의된 타입을 변경하려면 자바와 같이 형변황을 해야합니다.
    - val
        - 초기에 값을 할당되면 나중에 값을 변경할 수 없으며 값을 변경하게 되면 컴파일 에러가 발생한다.
        - 변수의 참조가 가리키는 객체의 내부 값은 변경이 가능합니다.
        
- when, if
    - when
        
        ```kotlin
        fun main(args: Array<String>) {
        	var x: Int? = 3
        	when (x) {
        	    1 -> print("x == 1")
        	    2 -> print("x == 2")
        	    else -> {
        	        print("x is neither 1 nor 2")
        	    }
        	}
        }
        ```
        
    - if
        
        ```kotlin
        val max = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        ```