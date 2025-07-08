# ⏰ WebSocket Timer App con Spring Boot y React

Este proyecto demuestra una integración entre un backend en Spring Boot que utiliza WebSockets nativos, y un frontend en React, para crear una aplicación que transmite la hora actualizada cada 5 segundos a todos los clientes conectados.

## 🚀 ¿Qué hace esta app?

Cada vez que un cliente abre la página web, se establece una conexión WebSocket con el servidor. Luego, el servidor envía la hora actual cada 5 segundos a todos los clientes conectados.

---

## 🧱 Estructura del Proyecto

### Backend (Java con Spring Boot)

#### `WSStartApp.java`

- Clase principal que arranca la aplicación Spring Boot.
- Anotada con `@EnableScheduling` para habilitar tareas programadas.

#### `TimerMessageBroker.java`

- Clase que utiliza la anotación `@Scheduled` para ejecutar `broadcastTime()` cada 5 segundos.
- Llama al método del handler WebSocket para emitir la hora actual.

#### `WSConfigurator.java`

- Configura el endpoint WebSocket `/timer` usando Spring WebSocket.
- Registra `TimerWebSocketHandler` para manejar conexiones entrantes.

#### `TimerWebSocketHandler.java`

- Extiende `TextWebSocketHandler` para manejar texto vía WebSockets.
- Gestiona la lista de sesiones activas.
- Implementa `broadcastTime()` para enviar la hora actual a todos los clientes conectados.
- Usa `SimpleDateFormat` para formatear la hora.

---

### Frontend (React)

#### `CanvasBoard.jsx` *(o `componente.jsx` en HTML)*

- Establece una conexión WebSocket al backend.
- Escucha mensajes del servidor y los muestra dinámicamente.
- Implementado con React y renderizado directamente en HTML mediante Babel.

---

## 🧠 Marco Teórico

### 🔌 ¿Qué es WebSocket?

WebSocket es un protocolo de comunicación que proporciona un canal bidireccional y full-duplex sobre una única conexión TCP. A diferencia de HTTP, WebSocket permite mantener abierta la conexión entre cliente y servidor, lo cual es ideal para aplicaciones en tiempo real (como chats, juegos, notificaciones, etc.).

**Ventajas:**

- Baja latencia
- Comunicación en tiempo real
- Menor sobrecarga de red que HTTP (evita múltiples requests)

---

### Diagrama de clases
![{D52B6A5C-F563-4751-AA6A-5EDD05CA42B0}](https://github.com/user-attachments/assets/e4b5c061-c2a2-4a3e-834d-2ebf48a8c02f)

---

### ⚛️ ¿Qué es React?

React es una librería de JavaScript para construir interfaces de usuario. Se basa en componentes y permite la actualización eficiente del DOM mediante un DOM virtual.

---

## 📦 Tecnologías Usadas

- **Backend**: Java 17, Spring Boot, Spring WebSocket
- **Frontend**: React 16, Babel (para JSX en HTML), JavaScript
- **WebSocket**: Protocolo WebSocket nativo
- **Programación reactiva**: `@Scheduled` para emitir mensajes periódicamente

---
## 📸 Capturas de pantalla

Primer ejercicio:  
![image](https://github.com/user-attachments/assets/03975614-4bfd-42ac-ab73-8855e826f546)

Segundo ejercicio:  
![{E87EBF76-2FAC-480F-A5C3-D0AC9F54E1D5}](https://github.com/user-attachments/assets/035b78d5-4123-4e4d-ae91-2143ffa78c62)
![{00311241-3942-4C25-8D05-1D947301B9FB}](https://github.com/user-attachments/assets/04be6f43-fbae-474f-b258-7fd5d8f54f97)

