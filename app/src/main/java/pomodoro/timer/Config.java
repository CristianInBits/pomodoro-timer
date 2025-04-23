package pomodoro.timer;

public class Config {

    // Duraciones en segundos para facilitar pruebas. Puedes cambiarlas luego a
    // minutos.
    public static final int WORK_DURATION = 25 * 60; // 25 minutos
    public static final int SHORT_BREAK_DURATION = 5 * 60; // 5 minutos
    public static final int LONG_BREAK_DURATION = 15 * 60; // 15 minutos

    public static final int WORK_SESSIONS_BEFORE_LONG_BREAK = 4;

    private Config() {
        // Constructor privado para evitar instanciación
    }
}
