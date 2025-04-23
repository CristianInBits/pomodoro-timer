package pomodoro.timer;

public class PomodoroApp {

    public static void main(String[] args) {

        TimeService timeService = new TimeService();
        int workSessionCount = 0;

        while (true) {

            // Sesión de trabajo
            timeService.runSession(SessionType.WORK, Config.WORK_DURATION);
            workSessionCount++;

            // ¿Descanso largo?
            if (workSessionCount % Config.WORK_SESSIONS_BEFORE_LONG_BREAK == 0) {
                timeService.runSession(SessionType.LONG_BREAK, Config.LONG_BREAK_DURATION);
            } else {
                timeService.runSession(SessionType.SHORT_BREAK, Config.SHORT_BREAK_DURATION);
            }

            // Separador visual entre ciclos
            System.out.println("🔁 Iniciando nuevo ciclo Pomodoro...\n");
        }
    }
}
