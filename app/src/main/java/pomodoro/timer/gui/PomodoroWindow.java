package pomodoro.timer.gui;

import javax.swing.*;
import java.awt.*;

public class PomodoroWindow extends JFrame {

    private JLabel timerLabel;
    private JButton startButton;

    private PomodoroController controller;

    public PomodoroWindow() {
        setTitle("🕒 Pomodoro Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centra la ventana

        // Componentes
        timerLabel = new JLabel("25:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 32));

        startButton = new JButton("Iniciar");

        controller = new PomodoroController(this);

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            controller.startNextSession();
        });

        // Layout
        setLayout(new BorderLayout());
        add(timerLabel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public PomodoroController getController() {
        return controller;
    }

    public void updateTime(int secondsLeft) {
        SwingUtilities.invokeLater(() -> timerLabel.setText(formatTime(secondsLeft)));
    }

    public void updateSessionLabel(pomodoro.timer.SessionType type) {
        String label;
        switch (type) {
            case WORK -> label = "🛠️ Trabajo";
            case SHORT_BREAK -> label = "☕ Descanso corto";
            case LONG_BREAK -> label = "🧘 Descanso largo";
            default -> label = "Pomodoro";
        }
        setTitle("Pomodoro Timer - " + label);
    }

    public void notifySessionEnd(pomodoro.timer.SessionType type) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(this, "✅ " + type.name().replace("_", " ") + " completado");
            getController().startNextSession(); // ← Aquí está la clave
        });
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
