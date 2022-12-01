# [개인 프로젝트] 다용도 목적의 게시판 기능 서비스
## 프로젝트 목적
- 게시판 기능 및 여러가지 기능을 추가하며 **프론트엔드**, **백엔드** 와 **배포**까지모두 공부하기 위해

## 기술 스택
### Front-end
<div>
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
</div>

### Back-end
<div>
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white">
<img src="https://img.shields.io/badge/Jpa-6DB33F?style=for-the-badge&logo=Jpa&logoColor=white">
<img src="https://img.shields.io/badge/Lombok-EF2D5E?style=for-the-badge&logo=Lombok&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
</div>

### Document
<div>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white">
</div>

### CI/CD
<div>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/Amazon AWS-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white">
<img src="https://img.shields.io/badge/Amazon S3-569A31?style=for-the-badge&logo=Amazon S3&logoColor=white">
</div>

## CI/CD 구조
![img](https://user-images.githubusercontent.com/36691759/205060109-29730385-ca9e-40b1-9e8e-d68d0b70c09e.png)

## 프로젝트 기능
### view 구성
### 1. 회원
**Layout**
- header.jsp - 상단의 메뉴바 구성
- footer.jsp - 하단의 페이지 정보를 표시할 수 있도록 구성

**User**
- joinForm.jsp - 회원가입을 하는 폼으로 사용
- loginForm.jsp - 로그인을 하는 폼으로 사용
- updateForm.jsp - 회원 정보를 수정하는 폼으로 사용

**Js**
- user.js - 사용자 정보에 대한 validation과 회원 가입, 회원 정보 업데이트시에 동작

### 2. 게시글 
**JSP**
- index.jsp - 게시글 리스트 출력
- detail.jsp - 특정 게시글을 눌렀을 경우, 글 정보 출력
- saveForm.jsp - 게시글 작성 시 동작
- updateForm.jsp - 존재하는 게시글의 내용 수정 시 동작

**Js**
- board.js - 각 글에 관련된 기능 API 호출

### 3. 댓글
**JSP**
- detail.jsp - 댓글 입력 부분과 댓글 리스트 목록 출력

**Js**
- board.js - 각 댓글 관련 저장, 삭제 기능

### service 구성
### 1. 회원
### 1-1. 회원가입 API 작성
**POST - /auth/joinProc**
- RequestBody로 회원가입하는 아이디, 비밀번호, 이메일주소 받기
- JS로 아이디 유효성 검사(4글자 이상)
- JS로 비밀번호 유효성 검사(소문자,대문자,숫자,특수문자 포함해서 8자리 이상 20자리 이하)
- JS로 이메일 유효성 검사(이메일 형식)
- 회원가입 성공 후 loginForm.jsp 페이지로 이동

**GET - /auth/username/{userName}**
- PathVariable로 검색할 유저네임 받기
- UserRepository에서 해당 유저네임이 있는지 유효성 검사

### 1-2. 로그인 API 작성
- spring-security(PrincipleDetail)설정으로 아이디, 비밀번호 받기
- 로그인 성공 후 index.jsp 페이지로 이동

### 1-3. 회원 정보 수정 API 작성
**PUT - /user**
- RequestBody로 변경할 비밀번호, 이메일주소 받기
- 아이디는 수정할 수 가 없다.
- 회원 정보 수정 후 index.jsp 페이지로 이동

### 2. 게시글
### 2-1. 게시글 작성
**POST - /api/board**
- @RequestBody로 게시글 제목, 카테고리와 글 내용 받기
- Users와 N:1 관계를 맺고 있다.

### 2-2. 게시글 수정
**PUT - /api/board/{id}**
- @PathVariable로 게시글 boardId 받기
- @RequestBody로 수정할 게시글 제목과 글 내용 받기
- 카테고리는 고정 값으로 수정 할 수 없다.

### 2-3. 게시글 삭제
**PUT - /api/board/{id}**
- @PathVariable로 게시글 boardId 받기

### 3. 댓글
### 3-1. 댓글 작성
**POST - /api/board/{boardId}/reply**
- @RequestBody로 userId, boardId 와 reply-content 받기

### 3-2. 댓글 삭제
**DELETE - /api/board/reply/{replyId}**
- @PathVariable로 댓글 replyId 받기
- 댓글을 작성한 사용자만 삭제 할 수 있다.

## 프로젝트 완성도 높이기
### AWS 서비스를 활용한 CI/CD
![img_1](https://user-images.githubusercontent.com/36691759/205060150-7db72ad7-16a8-4de2-95d0-759ceddb1935.png)
- EC2 인스턴스 백서버를 구축한다.
- buildspec.yml, appsepc.yml과 startup.sh 파일을 생성한다. 
- Codepipeline 을 구축하여, CodeBuild 와 CodeDeploy를 진행한다.
- EC2 인스턴스에 최종적으로 배포가 되어 서비스를 이용 할 수있다.

**배운 점**
- 프론트엔드와, 백엔드를 동시에 개발할 수 있어서 프로젝트와 완성도가 높았다.
- 처음 프로젝트를 구축 시, GitHub의 pull-request-templates 및 tag 설정.
- 자바스크립트를 활용한 이벤트 발생 및 유효성 검사 기능.
- GET, POST, PUT, DELETE 등 REST API를 활용한 점.
- 배포 시, 전에 사용했던 docker 컨테이너 형식의 배포 방식과 다른 AWS Codepipeline, Codebuild와 Codedeploy를 이용 한 점.
- 배포 시, 변경 사항이있으면 하나나 고쳐서 했던 예전과는 다르게, AWS CI/CD 사용해서 수고를 덜은 점.

**업데이트 하고싶은 사항**
- [x] CI/CD 환경 구축하기
- [ ] 다양한 CI/CD 환경 구축하기
- [ ] OAuth 2.0 적용 하기
- [ ] 챗 서버 구축하기


