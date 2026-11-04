import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {
        setTitle("Crime Management & Report System");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Crime Management & Report System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton victimButton = new JButton("Victim");
        JButton adminButton = new JButton("Admin");
        JButton investigatorButton = new JButton("Investigator");
        JButton exitButton = new JButton("Exit");

        victimButton.addActionListener(e -> {
            new VictimDashboard();
            dispose();
        });

        adminButton.addActionListener(e -> {
            new AdminLoginFrame();
            dispose();
        });

        investigatorButton.addActionListener(e -> {
            new InvestigatorLoginFrame();
            dispose();
        });

        exitButton.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel(new GridLayout(5, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        panel.add(titleLabel);
        panel.add(victimButton);
        panel.add(adminButton);
        panel.add(investigatorButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }
}