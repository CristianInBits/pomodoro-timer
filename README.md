# 🕒 Pomodoro Timer

Aplicación de consola en Java que implementa la técnica Pomodoro: ciclos de trabajo y descanso alternados automáticamente. Desarrollado como práctica de estructuras de control, temporizadores y programación modular.

---

## ✅ Funcionalidades

- Ciclos automáticos de trabajo y descanso.
- Descanso largo cada 4 sesiones de trabajo.
- Tiempos configurables desde la clase `Config`.
- Mensajes en consola con tiempo restante y tipo de sesión.
- Estructura limpia y modular.

---

## 🧠 Técnica Pomodoro implementada

| Tipo de sesión     | Duración  |
|--------------------|-----------|
| Trabajo            | 25 minutos |
| Descanso corto     | 5 minutos  |
| Descanso largo     | 15 minutos (cada 4 ciclos de trabajo) |

---

## 🗂️ Estructura del proyecto

```bash
pomodoro-timer/
├── app/
│   └── src/
│       └── main/
│           └── java/
│               └── pomodoro/
│                   ├── Config.java           # Configuración de tiempos y ciclos
│                   ├── PomodoroApp.java      # Clase principal con la lógica del ciclo
│                   ├── SessionType.java      # Enum con tipos de sesión
│                   └── TimerService.java     # Temporizador y mensajes en consola
├── build.gradle
├── settings.gradle
└── README.md
```

---

## 🚀 Tecnologías

- Java 17+
- Gradle
- VS Code

---

## 💡 Próximas mejoras (ideas)

- Configuración de tiempos desde la consola
- Mostrar cuenta regresiva dinámica
- Soporte para detener o pausar el temporizador
- Estadísticas de sesiones completadas
- Versión con interfaz gráfica (Swing o JavaFX)

---

## 👨‍💻 Ejecución

Desde la raíz del proyecto, compilar y ejecutar con:

```bash
./gradlew build
java -cp app/build/classes/java/main pomodoro.timer.PomodoroApp
```
