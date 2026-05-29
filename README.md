# Student Management System (SMS)

A lightweight, enterprise-ready web application built with **Java Spring Boot**, **MySQL**, and **Thymeleaf**. Designed specifically for instructors, this application provides a centralized, streamlined interface to manage student academic records and track performance seamlessly without the overhead of complex security configurations.

---

## 🏗️ System Architecture & Component Flow

The application is built using the robust **Model-View-Controller (MVC)** architectural design pattern, completely decoupling the presentation, business logic, and data layers as outlined below:

*   **Presentation Layer (Web UI):** Uses dynamic server-side **Thymeleaf HTML templates** stylized with a responsive **Bootstrap UI**. It captures teacher inputs and displays real-time data back to the user.
*   **Controller Layer:** The main entry point for incoming HTTP web requests within the Spring Boot framework. It maps endpoints, handles routing, and binds form parameters.
*   **Service Layer (Core Business Logic):** The middle tier that handles processing logic. It decouples client-side data from database operations and automatically handles background calculations.
*   **Repository Layer (Data Access):** Leverages **Spring Data JPA** to abstractly execute standard CRUD operations and query mapping against the persistent database layer.
*   **Database:** A relational **MySQL database** configured with structured schemas to store persistent student entities.

---

## ⚡ Features

*   **Complete CRUD Capabilities:** Easily **C**reate new students, **R**ead/view the consolidated roster, **U**pdate profiles, and **D**elete entries via a clean single-user admin interface.
*   **Automated Score Calculation:** Features built-in backend logic that automatically calculates a student's `totalMarks` from separate inputs (`mathMarks`, `scienceMarks`, `englishMarks`) before saving or modifying a record.
*   **Teacher-Centric Design:** Stripped of complex registration and multi-tenant authorization screens, allowing the application dashboard to load immediately upon launch.

---

## 🗄️ Database Schema (ERD Model)

The system relies on a clean, single relational model mapped directly to MySQL:

| Field | Data Type | Description |
| :--- | :--- | :--- |
| `id` | `INT` | Primary Key, configured for Auto-Increment |
| `name` | `VARCHAR` | Full name of the student |
| `rollNumber` | `VARCHAR` | Unique academic identifier |
| `email` | `VARCHAR` | Contact email address |
| `mathMarks` | `INT` | Scores obtained in Mathematics |
| `scienceMarks` | `INT` | Scores obtained in Science |
| `englishMarks` | `INT` | Scores obtained in English |
| `totalMarks` | `INT` | Derived attribute calculated automatically in the Service Layer |

---

## 🛠️ Tech Stack

*   **Backend:** Java 17+, Spring Boot (Spring Web, Spring Data JPA)
*   **Frontend:** Thymeleaf, HTML5, CSS3, Bootstrap (via CDN)
*   **Database:** MySQL
*   **Build Tool:** Maven

---

## 🚀 Getting Started & Local Installation

### Prerequisites
* Java Development Kit (JDK 17 or higher)
* Maven installed
* MySQL Server running locally

### 1. Clone the Repository
```bash
git clone [https://github.com/Vinit-co-2711/SMS-Student-Management-System.git](https://github.com/Vinit-co-2711/SMS-Student-Management-System.git)
cd SMS-Student-Management-System
