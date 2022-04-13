# JobExecution

### 기본 개념

- JobIstance에 대한 한번의 시도를 의미하는 객체로서 Job실행중에 발생한 정보들을 저장하고 있는 객체
    - 시작시간, 종료시간, 상태(시작됨, 완료, 실패), 종료상태의 속성을 가짐
- JobInstance과의 관계
    - JobExecution은 ‘FAILED’ 또는 ‘COMPLETED’ 등의 Job의 실행 결과 상태를 가지고 있음
    - JobExcution의 실행 상태 결과가 ‘COMPLETED’면 JobInstance 실행이 완료된 것으로 간주해서 재 실행이 불가함
    - JobExecution의 실행 상태 결과가 ‘FAILED’면 JobInstance실행이 완료되지 않은것으로 간주해서 재실행이 가능함
        - JobParameter가 동일한 값으로 Job을 실행할지라도 JobInstance를 계속 실행할 수 있음
    - JobExecution의 실행 상태 결과가 ‘COMPLETED’될때까지 하나의 JobInstance내에서 여러 번의 시도가 생길수 있음
    

### BATCH_JOB_EXECUTIOn테이블과 매핑

- JobInstance와 JobExecution는 1:M의 관계로서 JobInstance에 대한 성공 / 실패의 내역을 가지고 있음

![스크린샷 2022-04-13 오후 9.42.35.png](image/JobExecuti%20e3c7f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-13_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_9.42.35.png)

![스크린샷 2022-04-13 오후 9.42.45.png](image/JobExecuti%20e3c7f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-13_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_9.42.45.png)

![스크린샷 2022-04-13 오후 9.42.56.png](image/JobExecuti%20e3c7f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-13_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_9.42.56.png)