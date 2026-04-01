# 📚 KIc 웹개발자 양성과정 강의 자료

> **KIc (한국정보교육원) 웹개발자 양성과정 7개월 커리큘럼 (2016~2017)**  
> NCS(국가직무능력표준) 기반 풀스택 웹 개발 교육과정의 전체 강의·실습 자료 아카이브

---

## 📋 목차

- [과정 개요](#-과정-개요)
- [분석 결과 요약](#-분석-결과-요약)
- [커리큘럼 구성](#-커리큘럼-구성)
- [폴더 구조](#-폴더-구조)
- [기술 스택](#-기술-스택)
- [프로젝트](#-프로젝트)
- [NCS 평가](#-ncs-평가)
- [English Version](./README.md)

---

## 🎯 과정 개요

| 항목 | 내용 |
|------|------|
| **과정명** | 웹개발자 양성과정 |
| **교육기관** | KIc 한국정보교육원 |
| **교육기간** | 약 7개월 (2016.10 ~ 2017.04) |
| **수료일** | 2017.04.24 (수료) |
| **교육방식** | NCS 기반 이론 + 실습 + 프로젝트 |
| **주요 목표** | Java 기반 Full-Stack 웹 개발자 양성 |

---

## 📊 분석 결과 요약

### 커리큘럼 일정 분석

| Phase | 주제 | 교육일수 | 비중 |
|-------|------|:--------:|:----:|
| 1 | 📊 Database (Oracle, SQL) | ~10일 | 8% |
| 2 | 🌐 Client-Side (HTML5, CSS3, JS) | 8일 | 6% |
| 3 | ☕ Java Programming | 29일 | 23% |
| 4 | 🖥️ JSP/Servlet | 16일 | 13% |
| 5 | 🔧 Git/GitHub | 2일 | 2% |
| 6 | ⚡ Ajax, jQuery, Bootstrap | 12일 | 10% |
| 7 | 🍃 Spring Framework (MVC, MyBatis, AOP) | 18일 | 14% |
| 8 | 🚀 Modern Web (TypeScript, Angular, React) | 20일 | 16% |
| 9 | 🔒 Secure Coding | 3일 | 2% |
| 10 | 📱 Web Mobile (jQuery Mobile, Cordova) | 4일 | 3% |
| — | 🏆 **최종 프로젝트** | **~35일 (7주)** | — |
| | | **총 ~157일 + 프로젝트 7주** | |

### 저장소 통계

| 항목 | 수치 |
|------|:----:|
| 📁 총 폴더 수 | 27개 (메인 디렉터리) |
| 📚 주요 커리큘럼 폴더 | 10개 (Phase 1~10) |
| 📦 WAR 배포 파일 | 16개 (`8.4war파일/`) |
| 📝 NCS 평가 항목 | 7종 |
| 🏆 프로젝트 | 미니 5개 + 팀 2개 |
| 🛠 기술 스택 | Back-End 5 · Front-End 7 · DevOps 5 · 보안 2 = **총 19개** |

### 학습 경로 시각화

```
[DB 기초] → [HTML/CSS/JS] → [Java 심화] → [JSP/Servlet] → [Git]
     ↓                                          ↓
[Ajax/jQuery/Bootstrap] → [Spring/MyBatis] → [Modern Web]
     ↓                           ↓               ↓
[Secure Coding] → [Web Mobile] → [★ 최종 프로젝트 (7주) ★]
```

### 핵심 키워드

> **Java** · **Spring MVC** · **MyBatis** · **Oracle** · **JSP/Servlet** · **jQuery** · **Bootstrap** · **Angular** · **React** · **TypeScript** · **Ajax** · **Git** · **Secure Coding** · **Cordova** · **NCS**

---

## 📖 커리큘럼 구성

### Phase 1: 데이터베이스 (`1.db`)
> Oracle DB 기초부터 고급 SQL 활용까지

| 순서 | 주제 | 주요 내용 |
|------|------|-----------|
| 1 | DB 구현 | Oracle 설치, 테이블 생성, CRUD |
| 2 | SQL 활용 | 조인, 서브쿼리, 페이징 처리 |
| 3 | 사용자 권한 | Oracle 사용자 관리, 권한 부여 |

---

### Phase 2: 클라이언트 사이드 (`2.client`)
> HTML5, CSS3, JavaScript 기초 — 8일 과정

| 일차 | 주제 |
|------|------|
| 1일차 | 환경설정 (Chrome, EditPlus), HTML5 기초 |
| 2일차 | HTML5 웹 폼, 멀티미디어, CSS 개요 및 작성법 |
| 3일차 | CSS 사용법 심화, JavaScript 개요 및 작성법 |
| 4일차 | JavaScript 기본문법 (연산자, 제어문, 함수) |
| 5일차 | JavaScript 이벤트 처리, 제어문 심화 |
| 6일차 | JavaScript DOM 개요 및 작성법 |
| 7일차 | 미니 프로젝트 1 — 상단 메뉴 및 메인페이지 작성 |
| 8일차 | 미니 프로젝트 2 — 메인페이지 완성 |

---

### Phase 3: Java 프로그래밍 (`3.java`)
> Java 기초부터 JDBC, 미니 프로젝트까지 — 29일 과정

| 일차 | 주제 |
|------|------|
| 1~2일차 | Java 설치, 환경설정, 변수 (8가지 자료형) |
| 3~4일차 | 연산자, 제어문 (switch, for, while, break) |
| 5~7일차 | 객체지향 프로그래밍 (추상화, 캡슐화, 다형성, 오버로딩) |
| 8~9일차 | 배열, 2차원 배열, 상속, 오버라이딩 |
| 10~11일차 | 상속 심화, static, final, 추상클래스, 인터페이스 |
| 12~13일차 | 윈도우 프로그래밍 (AWT, Swing), 이벤트 처리, 예외 처리 |
| 14~15일차 | 객체 형변환, 라이브러리, 입출력 |
| 16~17일차 | 입출력, 쓰레드, 동기화, 컬렉션 |
| 18~19일차 | 제네릭, 네트워크 프로그래밍 |
| 20일차 | 자바 총정리 |
| 21~25일차 | **JDBC Programming** — 도서관리 프로젝트 (고객/도서/대여/반납 관리) |
| 26일차 | NCS 문제풀이, 람다 함수 |
| 27~29일차 | **미니 프로젝트** (3일간) |

---

### Phase 4: JSP 웹 프로그래밍 (`4.jsp`)
> 서블릿, JSP, MVC 패턴 — 16일 과정

| 일차 | 주제 |
|------|------|
| 1일차 | 웹개발 환경 구축, JSP 작성법 |
| 2일차 | 서블릿 프로그래밍 개요 및 작성법 |
| 3~4일차 | 내장객체, 액션태그, 템플릿 |
| 5일차 | 자바빈즈, 쿠키/세션, JDBC |
| 6~8일차 | **회원관리** — 로그인, 중복체크, 우편번호 검색, 회원가입/수정/탈퇴 |
| 9~12일차 | **모델1 게시판** — 페이징, 글쓰기/목록/상세/답변/수정/삭제, EL/JSTL |
| 13일차 | JSTL 문법 마무리, 모델2(MVC) 개요 |
| 14~16일차 | **모델2 게시판** — 글 목록/쓰기/상세/수정/삭제/조회 |

---

### Phase 5: 형상관리 (`5.형상관리`)
> Git & GitHub 활용법 — 2일 과정

| 일차 | 주제 |
|------|------|
| 1일차 | Git 설치, 개요 및 사용법 |
| 2일차 | Eclipse와 GitHub 연동 방법 |

---

### Phase 6: Ajax & jQuery & Bootstrap (`6.Ajax & JQuery`)
> Ajax, jQuery, Bootstrap 프레임워크 — 12일 과정

| 일차 | 주제 |
|------|------|
| 1일차 | DOM & Ajax Programming |
| 2~3일차 | jQuery 개요, 선택자, DOM 활용 |
| 4~5일차 | jQuery 이벤트 처리 |
| 6~7일차 | jQuery Effect, Ajax를 통한 DB 연동 |
| 8일차 | jQuery Ajax 마무리, Bootstrap 개요 |
| 9~10일차 | Bootstrap CSS 작성법 |
| 11~12일차 | Bootstrap Component 작성법 |

---

### Phase 7: Spring Framework (`7.spring`)
> Spring MVC, MyBatis, AOP — 18일 과정

| 일차 | 주제 |
|------|------|
| 1일차 | Spring 개요 및 환경설정 |
| 2일차 | DI (Dependency Injection) 개요 및 작성법 |
| 3~4일차 | Spring JDBC Programming, 어노테이션 |
| 5~6일차 | Spring MVC 프로그래밍 (게시판) |
| 7~8일차 | Spring 게시판 (목록/쓰기/상세/수정/삭제/검색) + MyBatis 설정 |
| 9일차 | MyBatis 게시판 CRUD 구현 |
| 10일차 | Maven 설정, Spring Tiles (메인페이지) |
| 11~15일차 | **파일 업로드 게시판** (목록/쓰기/상세/다운로드/수정/삭제) |
| 16~18일차 | **Spring AOP** 개요 및 작성법 |

---

### Phase 8: Modern Web (`8.web`)
> TypeScript, Angular, React, Secure Coding

| 주제 | 일수 | 주요 내용 |
|------|------|-----------|
| **TypeScript** | 2일 | 환경설정, ES6 문법, TypeScript 작성법 |
| **Angular** | 10일 | 컴포넌트, 바인딩, 서비스, 모듈, 지시자, 파이프, 라우터, RxJS, 회원관리 프로그램 |
| **React** | 5일 | 환경설정, Props/State, 생명주기, 이벤트, React Router, 전화번호 관리 프로젝트 |
| **시큐어 코딩** | 3일 | XSS, SQL Injection, 자바 암호화 |

---

### Phase 9: 보안 (`9.secure`)
> 시큐어 코딩 심화 — 3일 과정

| 일차 | 주제 |
|------|------|
| 1일차 | 시큐어 코딩 개요 및 작성법 |
| 2일차 | XSS 리뷰, 신뢰하지 않는 사이트 이동 금지, SQL Injection |
| 3일차 | SQL Injection 심화, 자바 암호화 |

---

### Phase 10: 웹 모바일 (`10.webmobile`)
> jQuery Mobile, Cordova — 4일 과정

| 일차 | 주제 |
|------|------|
| 1일차 | jQuery Mobile 환경설정, Template 작성법 |
| 2일차 | 화면 전환 및 다양한 컴포넌트 활용 |
| 3일차 | jQuery Mobile과 DB 연동 |
| 4일차 | Android Studio 설정, Cordova 환경설정 및 사용법 |

---

## 📂 폴더 구조

```
KIcListOfLectures/
│
├── 1.db/                      # 📊 데이터베이스 (Oracle, SQL)
│   ├── 1.db구현/              #   DB 구현 실습
│   ├── 2.SQL활용/             #   SQL 활용 실습
│   ├── oracle ppt/            #   Oracle 강의 자료
│   └── 과제/                  #   과제물
│
├── 2.client/                  # 🌐 클라이언트 (HTML5, CSS3, JavaScript)
│   ├── 1일차~8일차/           #   일별 강의·실습 자료
│   ├── html5/                 #   HTML5 예제
│   ├── web 자료 PPT/          #   웹 기초 강의 슬라이드
│   └── 과제/                  #   과제물
│
├── 3.java/                    # ☕ Java 프로그래밍
│   ├── 1일차~29일차/          #   일별 강의·실습 자료
│   ├── javaPPT/               #   Java 강의 슬라이드
│   ├── 도서관리 프로젝트자료/  #   JDBC 도서관리 프로젝트
│   ├── 자바프로젝트 자료/     #   미니 프로젝트
│   └── 과제/                  #   과제물
│
├── 4.jsp/                     # 🖥️ JSP/Servlet 웹 프로그래밍
│   ├── 1일차~16일차/          #   일별 강의·실습 자료
│   ├── JSP ppt/               #   JSP 강의 슬라이드
│   ├── 모델1 회원관리자료/    #   모델1 MVC 자료
│   ├── 모델1의 게시판자료/    #   게시판 구현 자료
│   └── 과제/                  #   과제물
│
├── 5.형상관리/                # 🔧 형상관리 (Git, GitHub)
│   ├── 1일차~2일차/           #   Git/GitHub 실습
│   └── Git,GitHub PPT/        #   강의 슬라이드
│
├── 6.Ajax & JQuery/           # ⚡ Ajax, jQuery, Bootstrap
│   ├── 1일차~12일차/          #   일별 강의·실습 자료
│   └── springppt자료/         #   강의 슬라이드
│
├── 7.spring/                  # 🍃 Spring Framework
│   ├── 1일차~18일차/          #   일별 강의·실습 자료
│   ├── springppt자료/         #   Spring 강의 슬라이드
│   └── springfileboard자료/   #   파일 업로드 게시판
│
├── 8.web/                     # 🚀 Modern Web (TS, Angular, React)
│   ├── typescript/            #   TypeScript 기초
│   ├── angular/               #   Angular 실습 (10일)
│   ├── react/                 #   React 실습 (5일)
│   └── 시큐코딩/              #   시큐어 코딩
│
├── 9.secure/                  # 🔒 보안 (시큐어 코딩)
│   ├── 1일차~3일차/           #   XSS, SQL Injection, 암호화
│   └── ppt/                   #   강의 슬라이드
│
├── 10.webmobile/              # 📱 웹 모바일 (jQuery Mobile, Cordova)
│   ├── 1일차~4일차/           #   모바일 개발 실습
│   └── cordova/               #   Cordova 하이브리드 앱
│
├── 8.4war파일/                # 📦 배포용 WAR 파일 모음
│
├── project최종/               # 🏆 최종 프로젝트 (7주간)
│   ├── 1주차~7주차/           #   주차별 진행 자료
│   └── 화면구현프로젝트/      #   최종 결과물
│
├── final 프로젝트자료/        # 📁 파이널 프로젝트 참고 자료
│   ├── 스토리보드/            #   프로젝트 기획
│   ├── 쇼핑몰 구축프로젝트/   #   쇼핑몰 프로젝트
│   └── 스프링프로젝트/        #   Spring 프로젝트
│
├── ncs문제풀이/               # 📝 NCS 국가직무능력표준 평가
├── javaPPT/                   # 📊 Java 강의 PPT 모음
├── jquery자료/                # 📚 jQuery 참고 자료
├── 팀별발표자료/               # 👥 팀별 발표 자료 (개인별 폴더)
├── 프로젝트수료(2016.4.27)/   # 🎓 수료 프로젝트 영상
├── 프로젝트자기수영상/         # 🎥 프로젝트 자기소개 영상
├── 프로젝트자료/               # 📋 프로젝트 기타 자료
└── 2017.4.24일 수료 PPT/     # 🎓 수료식 발표 PPT
```

---

## 🛠 기술 스택

### Back-End
| 기술 | 활용 |
|------|------|
| **Java** | 핵심 프로그래밍 언어 (OOP, JDBC, 네트워크, 쓰레드) |
| **JSP/Servlet** | 웹 애플리케이션 개발 (모델1/모델2 MVC) |
| **Spring Framework** | DI, Spring MVC, AOP |
| **MyBatis** | ORM 매핑, SQL 매퍼 |
| **Oracle DB** | 관계형 데이터베이스 |

### Front-End
| 기술 | 활용 |
|------|------|
| **HTML5/CSS3** | 웹 표준, 시멘틱 마크업 |
| **JavaScript** | DOM 제어, 이벤트 처리 |
| **jQuery** | DOM 조작, Ajax 통신 |
| **Bootstrap** | 반응형 웹 디자인 |
| **Angular** | SPA 프레임워크 (TypeScript 기반) |
| **React** | 컴포넌트 기반 UI 라이브러리 |
| **TypeScript** | 정적 타입 JavaScript |

### DevOps & 기타
| 기술 | 활용 |
|------|------|
| **Git/GitHub** | 형상관리, 소스코드 관리 |
| **Maven** | 빌드 도구, 의존성 관리 |
| **Apache Tomcat** | WAS (WAR 배포) |
| **Cordova** | 하이브리드 모바일 앱 |
| **jQuery Mobile** | 모바일 웹 UI |

### 보안
| 기술 | 활용 |
|------|------|
| **시큐어 코딩** | XSS 방어, SQL Injection 방지 |
| **자바 암호화** | 암호화/복호화 처리 |

---

## 🏆 프로젝트

### 미니 프로젝트
| 프로젝트 | 기술 스택 | 설명 |
|----------|-----------|------|
| 메인페이지 제작 | HTML5, CSS3, JS | 클라이언트 사이드 미니 프로젝트 |
| 도서관리 시스템 | Java, JDBC, Oracle | 고객/도서/대여/반납 관리 |
| Java 미니 프로젝트 | Java 전체 | 3일간의 Java 종합 프로젝트 |
| 전화번호 관리 | React | React 기반 CRUD 프로젝트 |
| 회원관리 프로그램 | Angular | Angular 기반 회원 CRUD |

### 팀 프로젝트
| 프로젝트 | 기간 | 설명 |
|----------|------|------|
| 화면구현 프로젝트 | 중간 | 팀별 Bootstrap 기반 웹페이지 |
| **최종 프로젝트** | **7주** | **Spring + MyBatis + Oracle 기반 풀스택 웹 프로젝트** |

---

## 📝 NCS 평가

NCS(국가직무능력표준) 기반의 평가가 과정 전반에 걸쳐 진행되었습니다:

- DB 구현 시험
- SQL 활용 문제풀이
- 프로그래밍 언어 활용
- 애플리케이션 구현
- 애플리케이션 배포
- 응용 SW 기초 기술 활용
- Angular & React 시험

---

## 📄 수료 자료

- **수료일**: 2017.04.24
- **수료 발표 PPT**: `2017.4.24일 수료 프로젝트자료 ppt/`
- **프로젝트 발표 영상**: `프로젝트수료(2016.4.27수료)/`, `프로젝트자기수영상/`

---

## 📌 참고사항

- 모든 강의 자료는 **일차별**(또는 주차별)로 정리되어 있어, 순서대로 학습 과정을 따라갈 수 있습니다.
- `8.4war파일/` 폴더에 각 단계별로 배포 가능한 WAR 파일이 포함되어 있습니다.
- `javaPPT/` 및 `jquery자료/`에 강의용 PPT 자료가 정리되어 있습니다.

---

## 📜 License

This repository is for educational and archival purposes.

---

*이 저장소는 KIc 한국정보교육원 웹개발자 양성과정을 수료하며 학습한 전체 자료를 아카이빙한 것입니다.*
