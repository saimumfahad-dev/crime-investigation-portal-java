import javax.swing.*;
import java.awt.*;

public class InvestigatorLoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public InvestigatorLoginFrame() {
        setTitle("Investigator Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        loginButton.addActionListener(e -> login());

        backButton.addActionListener(e -> {
            new WelcomeFrame();
            dispose();
        });

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(backButton);

        add(panel);
        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("investigator") && password.equals("inv123")) {
            new InvestigatorDashboard(username);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid investigator login.");
        }
    }
}