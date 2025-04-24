package pomodoro.timer.gui;

public class TimerThread extends Thread {

    private final int durationInSeconds;
    private final TimerListener listener;

    public interface TimerListener {
        void onTick(int remainingSeconds);

        void onFinish();
    }

    public TimerThread(int durationInSeconds, TimerListener listener) {
        this.durationInSeconds = durationInSeconds;
        this.listener = listener;
    }

    @Override
    public void run() {
        int remaining = durationInSeconds;
        while (remaining > 0 && !isInterrupted()) {
            try {
                Thread.sleep(1000);
                remaining--;
                listener.onTick(remaining);
            } catch (InterruptedException e) {
                interrupt(); // preservar el estado
                break;
            }
        }
        if (!isInterrupted()) {
            listener.onFinish();
        }
    }
}
