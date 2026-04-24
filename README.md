# whatsapp-bot

A minimal Spring Boot chatbot with a WhatsApp-style web UI. Send a message, get a reply — served entirely from `localhost:8080`.

---

## Preview

```
┌─────────────────────────────┐
│  🤖  WhatsApp Bot    ● online│
├─────────────────────────────┤
│                             │
│  ┌────────────────────────┐ │
│  │ Hey! Try saying hi 👋  │ │
│  └────────────────────────┘ │
│                             │
│  ┌──────────┐               │
│  │   hello  │               │  ← you
│  └──────────┘               │
│                             │
│  ┌──────────┐               │
│  │  Hello   │               │  ← bot
│  └──────────┘               │
│                             │
├─────────────────────────────┤
│  Message              [ → ] │
└─────────────────────────────┘
```

---

## Stack

| Layer    | Tech                          |
|----------|-------------------------------|
| Backend  | Java 21, Spring Boot 4.0.6    |
| Build    | Maven                         |
| Frontend | Vanilla HTML / CSS / JS       |
| Extras   | Lombok, Spring DevTools       |

---

## Project Structure

```
src/
└── main/
    ├── java/com/example/whatsapp_bot/
    │   ├── WhatsappBotApplication.java   # entry point
    │   ├── controller/
    │   │   └── WebhookController.java    # POST /webhook
    │   ├── service/
    │   │   └── ChatbotService.java       # response logic
    │   └── dto/
    │       ├── WhatsappMessageRequest.java
    │       └── WhatsappMessageResponse.java
    └── resources/
        ├── application.yaml
        └── static/                       # served at /
            ├── index.html
            ├── style.css
            └── script.js
```

---

## Getting Started

**Prerequisites:** Java 21+

```bash
# clone
git clone https://github.com/your-username/whatsapp-bot.git
cd whatsapp-bot

# run
./mvnw spring-boot:run          # macOS / Linux
mvnw.cmd spring-boot:run        # Windows
```

Open [http://localhost:8080](http://localhost:8080) and start chatting.

---

## API

```
POST /webhook
Content-Type: application/json
```

**Request**
```json
{
  "from": "user",
  "message": "hi"
}
```

**Response**
```json
{
  "reply": "Hello"
}
```

---

## Bot Responses

The bot is rule-based and case-insensitive.

| Input         | Reply                      |
|---------------|----------------------------|
| `hi`          | Hello                      |
| `bye`         | Goodbye                    |
| anything else | I did not understand that. |

To add new responses, edit `ChatbotService.java`:

```java
if (message.equalsIgnoreCase("thanks")) return "You're welcome!";
```

---

## Build a JAR

```bash
./mvnw clean package
java -jar target/whatsapp-bot-0.0.1-SNAPSHOT.jar
```

---

## License

MIT
# WhatsApp-Bot
