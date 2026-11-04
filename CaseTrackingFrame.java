import javax.swing.*;
import java.awt.*;

public class CaseTrackingFrame extends JFrame {

    private JTextField caseIdField;
    private JTextArea resultArea;

    public CaseTrackingFrame() {
        setTitle("Case Tracking");
        setSize(550, 450);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Track Your Case", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        caseIdField = new JTextField();
        JButton searchButton = new JButton("Search");

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        searchButton.addActionListener(e -> searchCase());

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        topPanel.add(new JLabel("Enter Case ID:"));
        topPanel.add(caseIdField);
        topPanel.add(new JLabel(""));
        topPanel.add(searchButton);

        add(titleLabel, BorderLayout.NORTH);
        add(topPanel, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void searchCase() {
        String caseId = caseIdField.getText();

        CrimeReport report = ReportService.findByCaseId(caseId);

        if (report == null) {
            resultArea.setText("No case found with this Case ID.");
        } else {
            resultArea.setText(
                    "Case ID: " + report.getCaseId() + "\n" +
                            "Incident Type: " + report.getIncidentType() + "\n" +
                            "Crime Category: " + report.getCrimeCategory() + "\n" +
                            "Place: " + report.getPlace() + "\n" +
                            "Status: " + report.getStatus() + "\n" +
                            "Assigned Investigator: " + report.getAssignedInvestigator()
            );
        }
    }
}