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

## 프로젝트 기능
### 1. 회원가입 API 작성
**POST - /auth/joinProc**
- RequestBody로 회원가입하는 아이디, 비밀번호, 이메일주소 받기
- JS로 아이디 유효성 검사(4글자 이상)
- JS로 비밀번호 유효성 검사(소문자,대문자,숫자,특수문자 포함해서 8자리 이상 20자리 이하)
- JS로 이메일 유효성 검사(이메일 형식)
- 회원가입 성공 후 loginForm.jsp 페이지로 이동

**GET - /auth/username/{userName}**
- PathVariable로 검색할 유저네임 받기
- UserRepository에서 해당 유저네임이 있는지 유효성 검사

### 2. 로그인 API 작성
- spring-security(PrincipleDetail)설정으로 아이디, 비밀번호 받기
- 로그인 성공 후 index.jsp 페이지로 이동

### 3. 회원 정보 수정 API 작성
**PUT - /user**
- RequestBody로 변경할 비밀번호, 이메일주소 받기
- 아이디는 수정할 수 가 없다.
- 회원 정보 수정 후 index.jsp 페이지로 이동
## 프로젝트 진행도
## 프로젝트 완성도 높이기




