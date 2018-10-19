# 개발순서

## 1. 디비 스키마 확인  
디비버전, 접근방법, 테이블, 칼럼 확인  
Data Source Explorer 뷰(실무에서는 Toad를 많이 사용)  

## 1.1. 디비 연동 기술 선택  
- Spring JDBC  
- MyBatis  
- JPA  

## 2. 디펜던시 설정  
디비 연결 드라이버  
pom.xml  

## 2.1. 빈컨테이너 설정  
root-context.xml  

## 3. Domain 클래스  
Emp.java <== 테이블 한 행의 정보를 자바 객체로 취급  

## 4. DAO  
EmpDao.java  
EmpDaoImpl.java  

## 4.1. TEST  

## 5. Controller  
EmpController.java  

## 6. JSP  
emp-list.jsp  

## 6.1. TEST  


