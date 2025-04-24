package pomodoro.timer.gui;

import pomodoro.timer.SessionType;
import pomodoro.timer.Config;;

public class PomodoroController {

    private final PomodoroWindow view;
    private int workSessionCount = 0;
    private TimerThread currentThread;

    public PomodoroController(PomodoroWindow view) {
        this.view = view;
    }

    public void startNextSession() {
        SessionType type;
        int duration;

        if (workSessionCount
                % (Config.WORK_SESSIONS_BEFORE_LONG_BREAK * 2) == Config.WORK_SESSIONS_BEFORE_LONG_BREAK * 2 - 1) {
            type = SessionType.LONG_BREAK;
            duration = Config.LONG_BREAK_DURATION;
            workSessionCount = 0; // reiniciar ciclo largo
        } else if (workSessionCount % 2 == 0) {
            type = SessionType.WORK;
            duration = Config.WORK_DURATION;
        } else {
            type = SessionType.SHORT_BREAK;
            duration = Config.SHORT_BREAK_DURATION;
        }

        view.updateSessionLabel(type);
        runTimer(duration, type);
        workSessionCount++;
    }

    private void runTimer(int durationInSeconds, SessionType type) {
        currentThread = new TimerThread(durationInSeconds, new TimerThread.TimerListener() {
            @Override
            public void onTick(int remainingSeconds) {
                view.updateTime(remainingSeconds);
            }

            @Override
            public void onFinish() {
                view.notifySessionEnd(type);
            }
        });
        currentThread.start();
    }

    public void stopCurrentTimer() {
        if (currentThread != null && currentThread.isAlive()) {
            currentThread.interrupt();
        }
    }

}
