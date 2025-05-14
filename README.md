# 🧠 UniZone Backend – Learning Microservices with Spring Boot

This project is created as a personal study to understand how to build and structure a backend system using 
**microservices architecture** in **Spring Boot (Kotlin)**. It demonstrates how separate services can communicate 
and operate independently while applying real-world backend techniques such as **JWT authentication**, **MongoDB**, **WebSocket**, and **RabbitMQ**.

---

## 🎯 Learning Goals

- Understand how to **separate concerns** across services.
- Learn to implement **token-based authentication**.
- Practice integrating **NoSQL (MongoDB)** and **SQL (MySQL)**.
- Explore **real-time messaging** using WebSocket and message brokers.
- Gain hands-on experience in configuring and running **independent services**.

---

## 🧱 Microservice Details

### 🔐 auth_service
- Manages **login**, **logout**, and **JWT token generation**.
- Validates tokens used by other services.
- **Focus:** Spring Security, Stateless Auth, MySQL

### 📰 newsfeed_service
- Generates a user's **newsfeed** based on who they follow.
- Uses logic inspired by Leetcode 355 – Design Twitter.
- **Focus:** Spring Web, MongoDB, RESTful APIs

### 💬 chat_service
- Handles **real-time chat** using **WebSocket** and **STOMP** protocol.
- Routes messages through **RabbitMQ** (direct exchange).
- **Focus:** WebSocket + STOMP + RabbitMQ integration

---

## ⚙️ Technologies Used

- Spring Boot (Kotlin)
- JWT (JSON Web Tokens)
- MySQL, MongoDB
- WebSocket & STOMP
- RabbitMQ
- Gradle (Kotlin DSL)
- Docker (for local containers)

---

## 🏗️ Project Structure

	•	📁 auth_service/: Auth & JWT management
	•	📁 newsfeed_service/: Newsfeed and follow logic
	•	📁 chat_service/: Real-time chat using WebSocket & RabbitMQ
	•	⚙️ .gitignore: Ignoring build/IDE files
	•	⚙️ build.gradle.kts: Gradle root build file
	•	⚙️ settings.gradle.kts: Multi-service project settings

Each folder represents an **independent microservice**, with its own configuration and Gradle build file.
---

## 🚀 How to Run

Ensure MongoDB, MySQL, and RabbitMQ are running (e.g., using Docker).

Start each service with:

```bash
./gradlew :auth_service:bootRun
./gradlew :newsfeed_service:bootRun
./gradlew :chat_service:bootRun

📝 Notes
	•	JWTs are generated in auth_service and passed via headers.
	•	Posts and follower relationships are stored in MongoDB (newsfeed_service).
	•	Chat messages are routed via RabbitMQ and delivered using WebSocket subscriptions.

📚 Status

This project is work-in-progress and used for learning and experimentation with microservice concepts.
Contributions and feedback are welcome for improvement.

📄 License

This project is created for educational and personal learning use only.
