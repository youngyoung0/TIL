# JobInstance

### 기본개념

- Job이 실행될 때 생성되는 Job의 논리적 실행 단위 객체로서 고유하게 식별 가능한 실행을 나타냄
- Job의 설정과 구성은 동일하지만 Job이 실행되는 시점에 처리하는 내용은 다르기 때문에 Job의 실행을 구분해야함
    - 하루에 한번씩 배치 Job이 실행된다면 매일 실행되는 각각의 Job을 JobInstance로 표현합니다.
- JobInstance 생성 및 실행
    - 처음 시작하는 Job + JobParameter일 경우 새로운 JobInstance 생성
    - 이전과 동일한 Job + Parameter으로 실행 할 경우 이미 존재하는 JobInstance 리턴
        - 내부적으로 JobName + JobKey(JobParametes의 해시값)를 가지고 JobInstance 객체를 얻음
    - Job과는 1:M 관계
    

### BATCH_JOB_INSTANCE 테이블과 매핑

- JOB_NAME(job)과 JOB_KEY(jobParameter 해시값)가 동일한 데이터는 중복해서 저장할 수 없음

![스크린샷 2022-04-13 오후 6.11.58.png](image/JobInstanc%20a8cd3/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-13_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_6.11.58.png)

![스크린샷 2022-04-13 오후 6.12.10.png](image/JobInstanc%20a8cd3/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-13_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_6.12.10.png)