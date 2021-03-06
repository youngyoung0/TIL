# Step

### 기본 개념

- Batch Job을 구성하는 독립적인 하나의 단계로서 실제 배치 처리를 정의하고 컨트롤러하는 데 필요한 모든 정보를 가지고 있는 도메인 객체
- 단순한 단일 테스크 뿐 아니라 입력과 처리 그리고 출력과 관련된 복잡한 로직을 포함하는 모든 설정증들을 담고 있다.
- 배치 작업을 어떻게 구성하고 실행할 것인지 Job의 세부 작업을 Task기반으로 설정하고 명세해 놓은 객체
- 모든 Job은 하나 이상의 step으로 구성도미

### 기본 구현체

- TaskletStep
    - 가장 기본이 되는 클래스로서 Tasklet타입의 구현체들을 제어한다
- PartitionStep
    - 멀티 스레드 방식으로 Step을 여러개로 분리해서 실행한다.
- JobStep
    - Step 내에서 Job을 실행하도록 한다.
- FlowStep
    - Step 내에서 Flow를 실행하도록 한다.
    

![스크린샷 2022-04-15 오후 3.22.07.png](image/Step%202624e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-15_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_3.22.07.png)

![스크린샷 2022-04-15 오후 3.22.15.png](image/Step%202624e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-15_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_3.22.15.png)

![스크린샷 2022-04-15 오후 3.22.23.png](image/Step%202624e/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-15_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_3.22.23.png)