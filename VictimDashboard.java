import javax.swing.*;
import java.awt.*;

public class VictimDashboard extends JFrame {

    public VictimDashboard() {
        setTitle("Victim Dashboard");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Victim Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        JButton reportButton = new JButton("Submit Crime Report");
        JButton trackButton = new JButton("Track Case");
        JButton backButton = new JButton("Back to Main Page");

        reportButton.addActionListener(e -> new CrimeReportForm());

        trackButton.addActionListener(e -> new CaseTrackingFrame());

        backButton.addActionListener(e -> {
            new WelcomeFrame();
            dispose();
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 70, 40, 70));

        panel.add(titleLabel);
        panel.add(reportButton);
        panel.add(trackButton);
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }
}