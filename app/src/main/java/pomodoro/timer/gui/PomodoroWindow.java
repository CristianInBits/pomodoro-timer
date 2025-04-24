package pomodoro.timer.gui;

import javax.swing.*;
import java.awt.*;

public class PomodoroWindow extends JFrame {

    private JLabel timerLabel;
    private JButton startButton;
    private TimerThread timerThread;

    public PomodoroWindow() {
        setTitle("🕒 Pomodoro Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centra la ventana

        // Componentes
        timerLabel = new JLabel("25:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 32));

        startButton = new JButton("Iniciar");

        startButton.addActionListener(e -> startTimer());

        // Layout
        setLayout(new BorderLayout());
        add(timerLabel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startTimer() {
        startButton.setEnabled(false); // desactivar botón

        int duration = 25 * 60; // 25 minutos (podés usar Config.WORK_DURATION si lo integrás)

        timerThread = new TimerThread(duration, new TimerThread.TimerListener() {
            @Override
            public void onTick(int remainingSeconds) {
                SwingUtilities.invokeLater(() -> timerLabel.setText(formatTime(remainingSeconds)));
            }

            @Override
            public void onFinish() {
                SwingUtilities.invokeLater(() -> {
                    timerLabel.setText("¡Fin!");
                    startButton.setEnabled(true); // permitir reinicio
                    JOptionPane.showMessageDialog(PomodoroWindow.this, "⏰ ¡Pomodoro terminado!");
                });
            }
        });

        timerThread.start();
    }

    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PomodoroWindow::new);
    }
}
