# Ollama Spring Boot Application

This is a Spring Boot application that integrates with the **Ollama** LLM service to process chat requests.  
It exposes a REST API for interacting with the model and demonstrates how to structure a service-driven Spring Boot app.

---

## 🚀 Project Structure

- **`OllamaspringApplication.java`**  
  The main entry point of the Spring Boot application. It boots the app using `SpringApplication.run`.

- **`ChatController.java`**  
  A REST controller that defines the HTTP endpoints for interacting with the application.

  - Exposes a `/chat` endpoint (likely `POST`) where you send a message to be processed.
  - Delegates processing to the `OllamaService`.

- **`OllamaService.java`**  
  A service component that contains the logic for interacting with the **Ollama API**.
  - Handles building requests to the model.
  - Processes responses and returns them back to the controller.

---

## ⚙️ Requirements

- Java 17 or later (Java 21 recommended)
- Maven 3.9+
- Spring Boot 3.x
- An **Ollama** server running locally or accessible via network

---

## 🛠️ Build & Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/your-repo.git
cd your-repo
```

### 2. Configure environment

If the Ollama service requires a base URL or API key, configure them in:

```bash
src/main/resources/application.properties
```

Example:

```bash
ollama.api.base-url=http://localhost:11434
```

### 3. Build the project

```bash
mvn clean package
```

### 4. Run the app

```bash
mvn spring-boot:run
```

Or run the packaged jar:

```bash
java -jar target/ollamaspring-0.0.1-SNAPSHOT.jar
```

## 📡 API Usage

### Endpoint: /chat

Send a message to the Ollama model.

**Request:**

```bash
curl -X POST http://localhost:8080/chat \
  -H "Content-Type: application/json" \
  -d '{"message": "Hello, how are you?"}'
```

**Response:**

```json
{
  "response": "Hi! I'm doing well. How can I help you today?"
}
```

## 📂 Example Workflow

1. Client sends a chat message → `ChatController`
2. Controller calls → `OllamaService`
3. Service sends request to Ollama API
4. Response is returned back to client

## 🧑‍💻 Development Notes

- Extend `OllamaService` to support multiple models or advanced features (streaming, parameters, etc.).
- Add exception handling for network or API errors.
- You can secure the endpoint with Spring Security if needed.

## 📜 License

MIT License (or update to your project’s license)
