## MongoDB로 게시판을 만듭니다

### 정리해봐야할 내용 + To-Do List

- MongoDB vs Cassandra
- NoSQL vs RDBMS
- MongoDB의 Transcation 지원 검증
- Collection의 필드를 객체로 래핑하는게 적절할지, 기본으로 지원하는 Wrapper Class로 하는게 적절할지 조금 더 고민해보기
- 단일 모듈로 할지 멀티 모듈로 구성할지 생각해보기
- NoSQL은 연관관계가 없으니까 어떻게 테이블+컬럼을 짜는게 좋은건지 더 알아보기
- MultipartFile Type을 사용할 수 있을까?


// Kotlin value class

#### 공통
- [ ] 예외 처리
- [ ] 테스트 코드 인프라 셋팅

#### 유저 도메인

- [x] 유저 생성
- [x] 유저 수정(권한 부여)

#### 게시글 도메인

- [x] 게시글 작성
- [x] 게시글 조회
- [ ] 게시글 수정
- [ ] 게시글 삭제

#### 댓글 도메인

- [ ] 댓글 작성
- [ ] 댓글 조회
- [ ] 댓글 수정
- [ ] 댓글 삭제

### 제작 과정 중 있었던 일들

[만들면서 발생한 일들 대충 정리](https://k-diger.github.io/posts/MongoDBWithSpringBoot/)