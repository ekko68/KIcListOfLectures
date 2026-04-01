# 📚 KIc Web Developer Training Program — Lecture Archive

> **KIc (Korea Information Education Center) Web Developer Training — 7-Month Curriculum (2016–2017)**  
> A complete archive of lecture materials and hands-on labs from an NCS (National Competency Standards) based full-stack web development training program.

---

## 📋 Table of Contents

- [Program Overview](#-program-overview)
- [Analysis Summary](#-analysis-summary)
- [Curriculum](#-curriculum)
- [Directory Structure](#-directory-structure)
- [Technology Stack](#-technology-stack)
- [Projects](#-projects)
- [NCS Assessments](#-ncs-assessments)
- [한국어 버전 (Korean Version)](./README_KR.md)

---

## 🎯 Program Overview

| Item | Details |
|------|---------|
| **Program** | Web Developer Training Course |
| **Institution** | KIc (Korea Information Education Center) |
| **Duration** | ~7 months (Oct 2016 – Apr 2017) |
| **Completion Date** | April 24, 2017 |
| **Methodology** | NCS-based Theory + Hands-on Labs + Team Projects |
| **Objective** | Train Java-based Full-Stack Web Developers |

---

## 📊 Analysis Summary

### Curriculum Schedule Analysis

| Phase | Topic | Training Days | Weight |
|-------|-------|:------------:|:------:|
| 1 | 📊 Database (Oracle, SQL) | ~10 days | 8% |
| 2 | 🌐 Client-Side (HTML5, CSS3, JS) | 8 days | 6% |
| 3 | ☕ Java Programming | 29 days | 23% |
| 4 | 🖥️ JSP/Servlet | 16 days | 13% |
| 5 | 🔧 Git/GitHub | 2 days | 2% |
| 6 | ⚡ Ajax, jQuery, Bootstrap | 12 days | 10% |
| 7 | 🍃 Spring Framework (MVC, MyBatis, AOP) | 18 days | 14% |
| 8 | 🚀 Modern Web (TypeScript, Angular, React) | 20 days | 16% |
| 9 | 🔒 Secure Coding | 3 days | 2% |
| 10 | 📱 Web Mobile (jQuery Mobile, Cordova) | 4 days | 3% |
| — | 🏆 **Capstone Project** | **~35 days (7 weeks)** | — |
| | | **Total: ~157 days + 7-week project** | |

### Repository Statistics

| Metric | Count |
|--------|:-----:|
| 📁 Total Directories | 27 (top-level) |
| 📚 Core Curriculum Folders | 10 (Phase 1–10) |
| 📦 WAR Deployment Files | 16 (`8.4war파일/`) |
| 📝 NCS Assessment Categories | 7 |
| 🏆 Projects | 5 mini + 2 team |
| 🛠 Technology Stack | Back-End 5 · Front-End 7 · DevOps 5 · Security 2 = **19 total** |

### Learning Path Visualization

```
[DB Basics] → [HTML/CSS/JS] → [Java Core] → [JSP/Servlet] → [Git]
     ↓                                            ↓
[Ajax/jQuery/Bootstrap] → [Spring/MyBatis] → [Modern Web]
     ↓                           ↓               ↓
[Secure Coding] → [Web Mobile] → [★ Capstone Project (7 weeks) ★]
```

### Key Technologies

> **Java** · **Spring MVC** · **MyBatis** · **Oracle** · **JSP/Servlet** · **jQuery** · **Bootstrap** · **Angular** · **React** · **TypeScript** · **Ajax** · **Git** · **Secure Coding** · **Cordova** · **NCS**

---

## 📖 Curriculum

### Phase 1: Database (`1.db`)
> Oracle DB fundamentals to advanced SQL

| # | Topic | Key Content |
|---|-------|-------------|
| 1 | DB Implementation | Oracle installation, table creation, CRUD operations |
| 2 | SQL Utilization | Joins, subqueries, pagination techniques |
| 3 | User Permissions | Oracle user management and privilege control |

---

### Phase 2: Client-Side Development (`2.client`)
> HTML5, CSS3, JavaScript fundamentals — 8 days

| Day | Topic |
|-----|-------|
| Day 1 | Environment setup (Chrome, EditPlus), HTML5 basics |
| Day 2 | HTML5 web forms, multimedia, CSS overview |
| Day 3 | Advanced CSS, JavaScript introduction |
| Day 4 | JavaScript fundamentals (operators, control flow, functions) |
| Day 5 | JavaScript event handling, advanced control flow |
| Day 6 | JavaScript DOM overview and implementation |
| Day 7 | Mini Project 1 — Navigation menu & main page (Part 1) |
| Day 8 | Mini Project 2 — Main page completion (Part 2) |

---

### Phase 3: Java Programming (`3.java`)
> Core Java to JDBC and mini projects — 29 days

| Days | Topic |
|------|-------|
| Days 1–2 | Java installation, environment setup, variables (8 data types) |
| Days 3–4 | Operators, control statements (switch, for, while, break) |
| Days 5–7 | OOP (abstraction, encapsulation, polymorphism, overloading) |
| Days 8–9 | Arrays, 2D arrays, inheritance, overriding |
| Days 10–11 | Inheritance deep dive, static, final, abstract classes, interfaces |
| Days 12–13 | Window programming (AWT, Swing), event handling, exception handling |
| Days 14–15 | Type casting, libraries, I/O streams |
| Days 16–17 | I/O streams, threads, synchronization, collections |
| Days 18–19 | Generics, network programming |
| Day 20 | Comprehensive Java review |
| Days 21–25 | **JDBC Programming** — Library Management System (customer/book/rental/return) |
| Day 26 | NCS problem solving, lambda expressions |
| Days 27–29 | **Mini Project** (3-day comprehensive project) |

---

### Phase 4: JSP Web Programming (`4.jsp`)
> Servlets, JSP, MVC Pattern — 16 days

| Days | Topic |
|------|-------|
| Day 1 | Web development environment setup, JSP basics |
| Day 2 | Servlet programming overview and implementation |
| Days 3–4 | Implicit objects, action tags, templates |
| Day 5 | JavaBeans, cookies/sessions, JDBC |
| Days 6–8 | **Member Management** — Login, duplicate ID check, zip code search, CRUD |
| Days 9–12 | **Model 1 Bulletin Board** — Paging, write/list/detail/reply/edit/delete, EL/JSTL |
| Day 13 | JSTL completion, Model 2 (MVC) introduction |
| Days 14–16 | **Model 2 Bulletin Board** — Full CRUD + search |

---

### Phase 5: Version Control (`5.형상관리`)
> Git & GitHub — 2 days

| Day | Topic |
|-----|-------|
| Day 1 | Git installation, overview, and usage |
| Day 2 | Eclipse and GitHub integration |

---

### Phase 6: Ajax, jQuery & Bootstrap (`6.Ajax & JQuery`)
> Ajax, jQuery library, Bootstrap framework — 12 days

| Days | Topic |
|------|-------|
| Day 1 | DOM & Ajax Programming |
| Days 2–3 | jQuery overview, selectors, DOM manipulation |
| Days 4–5 | jQuery event handling |
| Days 6–7 | jQuery effects, Ajax-based DB connectivity |
| Day 8 | jQuery Ajax wrap-up, Bootstrap introduction |
| Days 9–10 | Bootstrap CSS |
| Days 11–12 | Bootstrap Components |

---

### Phase 7: Spring Framework (`7.spring`)
> Spring MVC, MyBatis, AOP — 18 days

| Days | Topic |
|------|-------|
| Day 1 | Spring overview and environment setup |
| Day 2 | DI (Dependency Injection) overview and implementation |
| Days 3–4 | Spring JDBC Programming, annotations |
| Days 5–6 | Spring MVC programming (bulletin board) |
| Days 7–8 | Spring bulletin board (full CRUD + search) + MyBatis setup |
| Day 9 | MyBatis CRUD implementation |
| Day 10 | Maven configuration, Spring Tiles (main page) |
| Days 11–15 | **File Upload Board** (list/write/detail/download/edit/delete) |
| Days 16–18 | **Spring AOP** overview and implementation |

---

### Phase 8: Modern Web Technologies (`8.web`)
> TypeScript, Angular, React, Secure Coding

| Topic | Days | Key Content |
|-------|------|-------------|
| **TypeScript** | 2 | Environment setup, ES6 syntax, TypeScript fundamentals |
| **Angular** | 10 | Components, binding, services, modules, directives, pipes, router, RxJS, member management app |
| **React** | 5 | Environment setup, props/state, lifecycle, events, React Router, phone book project |
| **Secure Coding** | 3 | XSS, SQL Injection, Java encryption |

---

### Phase 9: Security (`9.secure`)
> Secure Coding — 3 days

| Day | Topic |
|-----|-------|
| Day 1 | Secure coding overview and implementation |
| Day 2 | XSS review, untrusted site redirect prevention, SQL Injection |
| Day 3 | Advanced SQL Injection, Java encryption/decryption |

---

### Phase 10: Web Mobile Development (`10.webmobile`)
> jQuery Mobile, Apache Cordova — 4 days

| Day | Topic |
|-----|-------|
| Day 1 | jQuery Mobile setup, template creation |
| Day 2 | Screen transitions and component utilization |
| Day 3 | jQuery Mobile with DB integration |
| Day 4 | Android Studio setup, Cordova configuration |

---

## 📂 Directory Structure

```
KIcListOfLectures/
│
├── 1.db/                      # 📊 Database (Oracle, SQL)
│   ├── 1.db구현/              #   DB implementation labs
│   ├── 2.SQL활용/             #   SQL utilization labs
│   ├── oracle ppt/            #   Oracle lecture slides
│   └── 과제/                  #   Assignments
│
├── 2.client/                  # 🌐 Client-Side (HTML5, CSS3, JavaScript)
│   ├── Day 1–8/               #   Daily lecture & lab materials
│   ├── html5/                 #   HTML5 examples
│   ├── web 자료 PPT/          #   Web fundamentals slides
│   └── 과제/                  #   Assignments
│
├── 3.java/                    # ☕ Java Programming
│   ├── Day 1–29/              #   Daily lecture & lab materials
│   ├── javaPPT/               #   Java lecture slides
│   ├── 도서관리 프로젝트/      #   Library management (JDBC) project
│   ├── 자바프로젝트 자료/     #   Mini project resources
│   └── 과제/                  #   Assignments
│
├── 4.jsp/                     # 🖥️ JSP/Servlet Web Programming
│   ├── Day 1–16/              #   Daily lecture & lab materials
│   ├── JSP ppt/               #   JSP lecture slides
│   ├── 모델1 회원관리/        #   Model 1 MVC resources
│   ├── 모델1 게시판/          #   Bulletin board resources
│   └── 과제/                  #   Assignments
│
├── 5.형상관리/                # 🔧 Version Control (Git, GitHub)
│   ├── Day 1–2/               #   Git/GitHub labs
│   └── Git PPT/               #   Lecture slides
│
├── 6.Ajax & JQuery/           # ⚡ Ajax, jQuery, Bootstrap
│   ├── Day 1–12/              #   Daily lecture & lab materials
│   └── springppt자료/         #   Lecture slides
│
├── 7.spring/                  # 🍃 Spring Framework
│   ├── Day 1–18/              #   Daily lecture & lab materials
│   ├── springppt자료/         #   Spring lecture slides
│   └── springfileboard/       #   File upload board resources
│
├── 8.web/                     # 🚀 Modern Web (TS, Angular, React)
│   ├── typescript/            #   TypeScript fundamentals
│   ├── angular/               #   Angular labs (10 days)
│   ├── react/                 #   React labs (5 days)
│   └── 시큐코딩/              #   Secure coding
│
├── 9.secure/                  # 🔒 Security (Secure Coding)
│   ├── Day 1–3/               #   XSS, SQL Injection, encryption
│   └── ppt/                   #   Lecture slides
│
├── 10.webmobile/              # 📱 Web Mobile (jQuery Mobile, Cordova)
│   ├── Day 1–4/               #   Mobile development labs
│   └── cordova/               #   Cordova hybrid app
│
├── 8.4war파일/                # 📦 Deployable WAR files collection
│
├── project최종/               # 🏆 Final Project (7 weeks)
│   ├── Week 1–7/              #   Weekly progress materials
│   └── 화면구현프로젝트/      #   Final deliverables
│
├── final 프로젝트자료/        # 📁 Final project reference materials
│   ├── Storyboards/           #   Project planning docs
│   ├── Shopping Mall/         #   E-commerce project
│   └── Spring Project/        #   Spring-based project
│
├── ncs문제풀이/               # 📝 NCS exam prep & solutions
├── javaPPT/                   # 📊 Java lecture PPT collection
├── jquery자료/                # 📚 jQuery reference materials
├── 팀별발표자료/               # 👥 Team presentation materials
├── 프로젝트수료/               # 🎓 Completion project videos
├── 프로젝트자기수영상/         # 🎥 Project self-introduction videos
├── 프로젝트자료/               # 📋 Miscellaneous project resources
└── 2017.4.24 수료 PPT/       # 🎓 Graduation presentation slides
```

---

## 🛠 Technology Stack

### Back-End
| Technology | Usage |
|------------|-------|
| **Java** | Core programming language (OOP, JDBC, networking, threads) |
| **JSP/Servlet** | Web application development (Model 1 / Model 2 MVC) |
| **Spring Framework** | DI, Spring MVC, AOP |
| **MyBatis** | ORM mapping, SQL mapper |
| **Oracle DB** | Relational database management |

### Front-End
| Technology | Usage |
|------------|-------|
| **HTML5/CSS3** | Web standards, semantic markup |
| **JavaScript** | DOM manipulation, event handling |
| **jQuery** | DOM manipulation, Ajax communication |
| **Bootstrap** | Responsive web design framework |
| **Angular** | SPA framework (TypeScript-based) |
| **React** | Component-based UI library |
| **TypeScript** | Statically typed JavaScript |

### DevOps & Tools
| Technology | Usage |
|------------|-------|
| **Git/GitHub** | Version control, source code management |
| **Maven** | Build tool, dependency management |
| **Apache Tomcat** | Web application server (WAR deployment) |
| **Cordova** | Hybrid mobile app development |
| **jQuery Mobile** | Mobile web UI framework |

### Security
| Technology | Usage |
|------------|-------|
| **Secure Coding** | XSS defense, SQL Injection prevention |
| **Java Encryption** | Encryption/decryption implementation |

---

## 🏆 Projects

### Mini Projects
| Project | Tech Stack | Description |
|---------|------------|-------------|
| Main Page Design | HTML5, CSS3, JS | Client-side mini project |
| Library Management | Java, JDBC, Oracle | Customer/book/rental/return CRUD system |
| Java Mini Project | Core Java | 3-day comprehensive Java project |
| Phone Book App | React | React-based CRUD application |
| Member Management | Angular | Angular-based member CRUD application |

### Team Projects
| Project | Duration | Description |
|---------|----------|-------------|
| UI Implementation | Mid-term | Team-based Bootstrap responsive web pages |
| **Capstone Project** | **7 weeks** | **Full-stack web project using Spring + MyBatis + Oracle** |

---

## 📝 NCS Assessments

NCS (National Competency Standards) based assessments were conducted throughout the program:

- DB Implementation Exam
- SQL Utilization Problem Solving
- Programming Language Utilization
- Application Implementation
- Application Deployment
- Applied SW Fundamental Technology Utilization
- Angular & React Exam

---

## 📄 Completion Materials

- **Completion Date**: April 24, 2017
- **Graduation Presentations**: `2017.4.24일 수료 프로젝트자료 ppt/`
- **Project Demonstration Videos**: `프로젝트수료(2016.4.27수료)/`, `프로젝트자기수영상/`

---

## 📌 Notes

- All lecture materials are organized **day-by-day** (or week-by-week), allowing you to follow the learning progression sequentially.
- The `8.4war파일/` folder contains deployable WAR files from each stage of the program.
- `javaPPT/` and `jquery자료/` contain supplementary lecture slide presentations.

---

## 📜 License

This repository is for educational and archival purposes.

---

*This repository is a complete archive of all materials studied during the KIc Web Developer Training Program.*
