# Expense Tracker – Microservices-Based Backend

A modular expense tracking backend system built with a microservices architecture using Java Spring Boot. It leverages Kafka for event-driven communication, integrates with Mistral AI API for parsing user input, and is fully containerized with Docker for scalable deployments.

## 🧩 Microservices

1. **AuthService**
   - Handles user authentication and authorization using JWT.
   - Exposes login, signup, and token refresh APIs.
   
2. **UserService**
   - Manages user profiles, preferences, and related metadata.
   - Verifies user identity and forwards contextual data to other services.

3. **DSService (Data Service)**
   - Integrates with **Mistral AI API** to extract structured spend details from user input messages (like chats or text logs).
   - Publishes extracted transactions to Kafka topics.

4. **LedgerService**
   - Consumes events from Kafka.
   - Aggregates and stores categorized expense records for analytics and reporting.
   - Supports future ledger visualizations or budget projections.

## 🛠️ Tech Stack

- **Backend Framework:** Java (Spring Boot)
- **Communication:** Kafka (event-driven messaging)
- **Authentication:** JWT (JSON Web Tokens)
- **Persistence:** Hibernate, Spring Data JPA, MySQL
- **AI Integration:** Mistral AI API (for NLP-based spend extraction)
- **Containerization:** Docker
- **Build Tool:** Gradle
- **Architecture:** Microservices

## ⚙️ Architecture Overview

```text
[Client/Input]
     |
     V
 [AuthService] <-- JWT --> [UserService]
     |                          |
     |                      User Data
     V
 [DSService] --(Kafka Topic: spend.extract)--> [LedgerService]
                          |
                    [Mistral AI API]
