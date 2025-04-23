package pomodoro.timer;

public class TimeService {

    public void runSession(SessionType type, int durationInSeconds) {
        System.out.println("⏱️ Iniciando sesión: " + formatSessionName(type));
        System.out.println("Duración: " + (durationInSeconds / 60) + " minutos");

        try {
            for (int i = durationInSeconds; i > 0; i--) {
                Thread.sleep(1000); // espera 1 segundo
                if (i % 60 == 0 || i <= 10) {
                    System.out.println("⏳ Tiempo restante: " + formatTime(i));
                }
            }
        } catch (Exception e) {
            System.out.println("⚠️ La sesión fue interrumpida.");
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Sesión " + formatSessionName(type) + " completada.\n");
    }

    private String formatSessionName(SessionType type) {
        return switch (type) {
            case WORK -> "Trabajo";
            case SHORT_BREAK -> "Descanso corto";
            case LONG_BREAK -> "Descanso largo";
        };
    }

    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
