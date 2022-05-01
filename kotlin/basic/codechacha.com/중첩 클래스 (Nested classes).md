# 중첩 클래스 (Nested classes)

### 정의

중첨 클래스는 클래스 안에 클래스를 말합니다.

```kotlin
class OuterClass{
	...
 	class NestClass{ // -> 중첩 클래스
	...
	}
}
```

중첩(Nested) 클래스는 크게 두종류로 나눌수 있다.

- Static nested clas(정적 중첩 클래스)
- Non-static nested class(innser class라고 합니다, 비정적 중첩 클래스)

### Static Nested Class (정적 중첩 클래스)

- OuterClass의 지역변수의 접근이 불가능
- 외부에서 OuterClass.NestedClass로 객체 생성 가능
    
    ```kotlin
    fun main(args: Array<String>) {
    	val nested = OuterClass.StaticNestedClass();
    	nested.printItems();
    }
    
    class OuterClass{
    	val outerValue = 10
    	class StaticNestedClass {
    		private val innerValue = 20
    		fun printItems(){
    			println("value : $innerValue")
    		}
    	}
    }
    // return. : value : 20
    ```
    
    OuterClass 박에서 객체를 중첩클래스 객체를 생성할 수 없다.
    
    InnerClass는 OuterClass의 내부에서 객체를 생성
    
    InnerClass 내부에서 OuterClass의 내부 변수에 접근이 가능합니다.
    

### Non-static nested class, Inner Class (비정적 중첩 클래스)

비정적 중첩 클래스(Non-static nested class)는 Inner class라고 합니다.

- OuterClass의 지역변수 접근이 가능합니다.
- 외부에서 OuterClass.NestedClass로 객체 생성 불가능
    
    
    ```kotlin
    class OuterClass {
        val value = 10
        inner class InnerClass {
            private val value = 20
            fun printItems() {
    					println("inner: $value or ${this.value} or ${this@InnerClass.value}")
    					println("outer: ${this@OuterClass.value}")
            }
        }
    
        fun printItems() {
            val inner = InnerClass()
            inner.printItems()
        }
    }
    
    fun main(args: Array<String>) {
        val outer = OuterClass()
        outer.printItems()
    }
    ```
    
    InnerClass에서 value를 접근하면 OuterClass가 아닌 InnerClass의 value를 접근합니다. 마치 메소드를 Override하는 것처럼 현재 스코프가 InnerClass이고 동일한 이름의 변수가 Inner에도 있기 때문에 Inner를 우선적으로 사용합니다.
    
    OuterClass의 value를 접근하려면 변수명 앞에 this@className으로 OuterClass의 스코프에 있는 변수를 명시적으로 지정할 수 있습니다.