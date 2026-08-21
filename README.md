# 📚 Library Management System (Spring Boot Backend)

A robust RESTful backend API for managing a library's books, members, and borrowing workflows. Built from scratch using **Java Spring Boot**, **Spring Data JPA**, and **H2 Database**.

---

## 🚀 Features
* **Book Management:** Add, update, view, search, and delete books.
* **Member Management:** Register and manage library members.
* **Borrowing System:** Link books to members using a JPA `@ManyToOne` database relationship.
* **RESTful Endpoints:** Fully tested and exposed via standard HTTP methods (`GET`, `POST`, `PUT`, `DELETE`).

---

## 🛠️ Tech Stack
* **Java 17+**
* **Spring Boot (v3.3.0)**
* **Spring Data JPA (Hibernate)**
* **H2 In-Memory Database**
* **Maven** (Build Tool)

---

## 📂 Project Architecture
```text
src/main/java/org/example/
│
├── controller/         # Handles incoming HTTP requests (REST Endpoints)
│   ├── BookController.java
│   └── MemberController.java
│
├── entity/             # Database tables represented as Java objects
│   ├── Book.java       # Contains @ManyToOne relationship with Member
│   └── Member.java
│
├── repository/         # Interfaces for talking to the database
│   ├── BookRepository.java
│   └── MemberRepository.java
│
└── service/            # Business logic layer
    ├── BookService.java
    └── MemberService.java