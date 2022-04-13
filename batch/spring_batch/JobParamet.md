# JobParameter

### 기본 개념

- Job을 실행할 때 함께 포함되어 사용되는 파라미터를 가진 도메인 객체
- 하나의 Job에 존재할 수 있는 여러개의 JobInstance를 구분하기 위한 용도
- JobParameters와 JobInstance 1:1 관계

### 생성 및 바인딩

- 어플리케이션 실행시 주입
    - Java -jar LogBatch.jar requestDate = 20210101
- 코드로 생성
    - JobParameterBuilder, DefaultJobParametersConverter
- SpEL이용
    - @Value(”#{jobParameter[requestDate]}”), @JobScope. @StepScope 선언 필수
    

### BATCH_JOB_EXECUTION_PARAM 테이블과 매핑

- JOB_EXECUTION과 1:M의 관계

![스크린샷 2022-04-13 오후 8.26.10.png](image/JobParamet%202e90c/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-13_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_8.26.10.png)