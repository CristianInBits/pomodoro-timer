package pomodoro.timer.gui;

import javax.swing.*;
import java.awt.*;

public class PomodoroWindow extends JFrame {

    private JLabel timerLabel;
    private JButton startButton;

    public PomodoroWindow() {
        setTitle("🕒 Pomodoro Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centra la vista

        // Components
        timerLabel = new JLabel("25:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 32));

        startButton = new JButton("Iniciar");

        // Layout
        setLayout(new BorderLayout());
        add(timerLabel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PomodoroWindow::new);
    }
}
