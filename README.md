# Library Management System

A simple **Library Management System** built in Java using Hibernate ORM to manage **authors** and **books**. This project demonstrates the use of **one-to-many** and **many-to-one** relationships between entities.

---

## Features

- Add new **Authors**.
- Add new **Books** associated with an **Author**.
- Each **Author** can have multiple **Books** (One-to-Many).
- Each **Book** belongs to one **Author** (Many-to-One).
- Update and delete books and authors.
- Fetch authors along with their books.

---

## Technology Stack

- **Java** (JDK 1.8+)
- **Hibernate ORM** (ORM framework for Java)
- **MySQL** (Database)
- **Maven/Gradle** (Build tool)
- **JDBC** (Database connection)

---

## Database Design

### Author Table

| Field      | Type        | Description           |
|------------|------------|---------------------|
| id         | INT        | Primary Key         |
| name       | VARCHAR    | Author Name         |
| email      | VARCHAR    | Author Email        |

### Book Table

| Field      | Type        | Description           |
|------------|------------|---------------------|
| id         | INT        | Primary Key         |
| title      | VARCHAR    | Book Title          |
| price      | DOUBLE     | Book Price          |
| author_id  | INT        | Foreign Key to Author|

**Relationship:**

- **Author (1) → Book (Many)**: One author can write multiple books.
- **Book (Many) → Author (1)**: Each book belongs to one author.

---

## Project Structure

LibraryManagementSystem/
│
├─ src/
│ ├─ com.LibraryManagementSystem.Entity/
│ │ ├─ Author.java
│ │ └─ Book.java
│ │
│ ├─ com.LibraryManagementSystem.DAO/
│ │ └─ CRUD operations for Author and Book
│ │
│ ├─ com.LibraryManagementSystem.Controller/
│ │ └─ MainHibernate.java
│ │
│ └─ com.LibraryManagementSystem.Util/
│ └─ HibernateUtil.java
│
├─ hibernate.cfg.xml
├─ pom.xml / build.gradle
└─ README.md
