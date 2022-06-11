# Function Structure

## Arguments

- 인자가 많아지면 복잡도가 증가
- 3개의 인자가 최대
    - 외우기 어렵다
    - Introduce Parameter Object
        
        ```java
        public class Customer{
        	public amountInvoicedIn(DateRange)
        }
        ```
        

- 생성자의 많은 수의 인자를 넘겨야 한다면?
    - builder pattern를 사용해라
        
        ```java
        public static class NutritionFacts{
        		private final int servingSize;
        		private final int servings;
        		private final int calories;
        		private final int fat;
        		private final int sodium;
        		private final int carbohydrate;
        		
        		public static class Builder{
        				private final int servingSize;
        				private final int servings;
        
        				private int calories = 0;
        				private int fat = 0;
        				private carbohydrate = 0;
        				private int sodium = 0;
        
        				public Builder(int servingSize, int servings){
        					this.servinsSize = servingSize;
        					this.servings = servings;
        				}
        
        				public Builder calories(int val){
        					calories = val;
        					return this;
        				}
        
        				public Builder fat(int val){
        					fat = val;
        					return this;
        				}
        
        				public Builder sodium(int val){
        					carbohydrate = val;
        					return this;
        				}
        
        				public NutritionFacts build(){
        					return new NutritionFacts(this
        				}
        		}
        
        		private NutritionFacts(Builder builder){
        				servingSize = builder.servingSize;
        				servings = builder.servings;
        				calories = builder.calories;
        				fat = builder.fat;
        				sodium = builder.sodium;
        				carbohydrate = builder.carbohydrate;
        		}
        }
        ```
        
- Boolean 인자 사용 금지
    - true 경우를 위한일 / false 경우를 위한일 → 2개의 함수로 분리
    
- Innies not Outies (입력으로 작용해야한다. output으로 작용하면 안된다.)
    - output 인자를 사용하지 말라
    - Argument는 함수로 전달되는 것인지.
    - 함수로부터 변경되어 나오는 것이라고는 생각하지 않는다.
        
        ```java
        private String toSimpleText(Parse table, StringBuffer returnText){
        		if(table.parts == null){
        				simpleTextOfLeave(table, returnText);
        				simpleTextOfMore(table, returnText);
        				return returnText.toString();
        		}
        		simpleTextOfParts(table, mreturnText);
        		simpleTextOfMore(table,returntext);
        		return returnText.toString();
        }
        ```
        
    - output argument대신 return value로 처리
    
- the null defense
    - null을 전달/기대하는 함수는
        - boolean을 전달하는 만큼 잘못된것
        - null인 경우의 행위 + null이 아닌 경우의 행위
        - 2개의 함수를 만드는 것이 맞다.
    - null을 pseudo boolean로 쓰지마라 ( 널인경우 아닌경우)
    - defensive programming을 지양
        - 코드를 Null, 에러 체크로 더럽히지 말라
        - 팀원이나 단위 테스트를 못 믿는다는 말
        - null 여부를 지속적으로 조사할 것이 아니라
        - 단위 테스트에서 검증해야한다.
    - public api의 경우는 defensive하게 programming한다.

## The Step down Rule

- 모든 public은 위에 모든 private은 아래로
- public part만 사용자들에게 전달하면 됨
- 중요한 부분은 위로, 상세한 부분은 밑으로
- 편집자들은 마지막 부분을 필수적인 내용 전달 오류 없이 제거할 수 있다.
- 독자들은 제일 위에서부터 읽기 시작해서 지루해지면 그만 읽으면 된다.
- backward reference없이 top에서 bottom으로 읽을수있도록 한다.

## switches and cases

- 객체지향의 가장 큰 이점 중 하나는 의존성 관리 능력이다.
- 모듈A가 모듈B의 함수를 사용하는 경우
    - 독릭적으로 배포/컴파일/개발 불가
- 객체지향이 가능하게 하는 대단한것
    - run time 의존성은 그대로 둔채로 source code 의존성을 역전 시킴
    - 절차
        
        본래의 의존성을 제거
        
        polymorphic interface를 삽입
        
        모든 A는 인터페이스에 의존하고, 모듈 B는 인터페이스로 부터 derive한다.
        
    - B의 source code 의존성은 run time의존성과 반대가 된다.
    - Independent Deployability: one of 객체지향의 강점
- switch 문장은 독립적 배포에 방해가 된다.

<img width="243" alt="스크린샷 2022-06-11 오후 11 33 01" src="[https://user-images.githubusercontent.com/77282011/173192343-3d7ce82a-44bf-4371-9553-8a2b01fced37.png](https://user-images.githubusercontent.com/77282011/173192343-3d7ce82a-44bf-4371-9553-8a2b01fced37.png)">

각 case문장은 외부 모듈에 의존성을 갖는다.

다수의 다른 모델에 의존성을 갖을 수 있다.

fan-out problem 이라고 한다.

switch 문장에서 source code 의존성은 flow of control과 방향이 같다.

- switch 문장 제거 절차
    
    switch문장을 polymorphic interface호출로 변환
    
    case에 있는 문장들을 별도의 클래스로 추출하여 변경 영향이 발생하지 않도록 한다.