# DB 스키마 생성

### 스프링 배치 메타 데이터

- 스프링 배치의 실행 및 관리를 위한 목적으로 여러 도메인들(Job, Step, JobParameters...)의 정보들을 저장, 업데이트, 조회할 수있는 스키마 제공
- 과거, 현재의 실해에 대한 세세한 정보, 실행에 대한 실패 여부 등을 일목요연하게 관리함으로서 배치운용에 있어 리스크 발생시 빠른 대처 가능
- DB와 연동할 경우 필수적으로 메타 테이블이 생성되어야 함

### DB 스키마 제공

- 파일 위치 : /org.springframework/batch/core/schema-*.sql
- DB 유형별로 제공

### 스키마 생성 설정

- 수동 생성  - 쿼리 복사후 직접 실행
- 자동 생성 - spring.batch.jdbc.initialize-schema 설정
    - ALWAYS
        - 스크립트 항상 실행
        - RDBMS 설정이 되어 있을 경우 내장 DB보다 우선적으로 실행
    - ㄷEMBEDDED : 내장 DB일 때만 실행되며 스키마가 자동 생성됨, 기본값
    - NEVER
        - 스크립트 항상 실행안됨
        - 내장 DB일경우 스크립트가 생성이 안되기 때문에 오류 발생
        - 운영에서 수동으로 스크립트 생성 후 설정하는 것을 권장
        

### DB 예시

![스크린샷 2022-04-11 오후 11.34.15.png](image/DB%20%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B5%E1%84%86%E1%85%A1%20%20169b4/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-04-11_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_11.34.15.png)

### Job 관련 테이블

- BATCH_JOB_INSTANCE
    - Job이 실행될때 JobInstance정보가 저장되며 job_name과 job_key를 키로 하여 하나의 데이터를 저장
    - 동일한 job_key로 중복저장할수 없다.
- BATCH_JOB_EXECUTION
    - job의 실행접오가 저장되며 job생성, 시작, 종료 시간, 실행 사태, 메시지 등을 관리
- BATCH_JOB_EXECUTION_PARAMS
    - job과 함께 실행되는 jobParameter 정보를 저장
- BATCH_JOB_EXECUTION_CONTEXT
    - Job의 실행동안 여러가지 상태 정보, 공유 데이터를 직렬화 (json 형식)해서 저장
    - Step 간 서로 공유 가능함

### Step 관련 테이블

- BATCH_STEP_EXECUTION
    - Step의 실행정보가 저장되며 생성, 시작, 종료 시간, 실행상태, 메세지등을 관리
    - Step 별로 저장되며 Step간 서로 공유할수 없음