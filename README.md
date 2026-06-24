# ActiveMQ Client Project (Part 6)

This project is a simple Java Maven application that demonstrates how to send and receive messages using Apache ActiveMQ through the Java Message Service (JMS) API. It uses a publish/subscribe model with a topic named `news`.

## Overview

The project contains two main classes:

- `MessageSender` - publishes a text message to the ActiveMQ topic.
- `MessageReceiver` - subscribes to the same topic and prints any received messages.

This is a basic example for learning how JMS messaging works with an ActiveMQ broker.

## Technologies Used

- Java 17
- Maven
- Apache ActiveMQ 6.2.6
- Jakarta JMS
- Log4j 2

## Project Structure

- [pom.xml](pom.xml) - Maven configuration and project dependencies.
- [src/main/java/com/hnys/mq/MessageSender.java](src/main/java/com/hnys/mq/MessageSender.java) - Sends a message to the `news` topic.
- [src/main/java/com/hnys/mq/MessageReceiver.java](src/main/java/com/hnys/mq/MessageReceiver.java) - Listens for messages from the `news` topic.

## Prerequisites

Before running the project, make sure you have:

- Java 17 or higher installed
- Maven installed
- An ActiveMQ broker running locally

## Setting Up ActiveMQ

Start your ActiveMQ broker and ensure it is listening on:

- `tcp://localhost:61616`

If ActiveMQ is not running, the sender and receiver will fail to connect.

## How to Run the Project

### 1. Compile the project

```bash
mvn clean compile
```

### 2. Run the message sender

Open a terminal and run:

```bash
mvn exec:java -Dexec.mainClass=com.hnys.mq.MessageSender
```

### 3. Run the message receiver

Open a second terminal and run:

```bash
mvn exec:java -Dexec.mainClass=com.hnys.mq.MessageReceiver
```

### 4. Expected result

The sender publishes a message to the `news` topic, and the receiver should print a message similar to:

```text
Received message: Hello World
```

## Notes

- The code currently uses a topic named `news`.
- The sender sends a simple text message.
- The receiver uses an asynchronous message listener.
- The example is intended for learning and demonstration purposes.

## Troubleshooting

If you encounter connection issues:

- Check that ActiveMQ is running.
- Confirm the broker URL is correct: `tcp://localhost:61616`.
- Make sure no firewall or port restrictions are blocking the connection.
