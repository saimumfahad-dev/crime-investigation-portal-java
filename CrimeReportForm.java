import javax.swing.*;
import java.awt.*;

public class CrimeReportForm extends JFrame {

    private JComboBox<String> incidentTypeBox;
    private JComboBox<String> crimeCategoryBox;

    private JTextField dateField;
    private JTextField timeField;
    private JTextField placeField;
    private JTextField suspectField;
    private JTextField victimField;
    private JTextField witnessField;
    private JTextField evidenceField;

    private JTextArea descriptionArea;

    private JCheckBox accuracyCheck;
    private JCheckBox falseReportCheck;
    private JCheckBox privacyCheck;

    public CrimeReportForm() {
        setTitle("Crime Report Form");
        setSize(700, 750);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(15, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        incidentTypeBox = new JComboBox<>(new String[]{
                "Emergency Incident",
                "Occurred Incident"
        });

        crimeCategoryBox = new JComboBox<>(new String[]{
                "Theft/Robbery",
                "Assault/Violence",
                "Cybercrime",
                "Fraud/Financial Crime",
                "Harassment/Stalking",
                "Missing Person",
                "Vandalism",
                "Others"
        });

        dateField = new JTextField();
        timeField = new JTextField();
        placeField = new JTextField();
        suspectField = new JTextField();
        victimField = new JTextField();
        witnessField = new JTextField();
        evidenceField = new JTextField();

        descriptionArea = new JTextArea(4, 20);

        JButton uploadButton = new JButton("Choose Evidence File");
        uploadButton.addActionListener(e -> chooseEvidenceFile());

        accuracyCheck = new JCheckBox("Information is accurate");
        falseReportCheck = new JCheckBox("I understand false reporting consequences");
        privacyCheck = new JCheckBox("I agree to the privacy policy");

        JButton submitButton = new JButton("Submit Report");
        submitButton.addActionListener(e -> submitReport());

        mainPanel.add(new JLabel("Incident Type:"));
        mainPanel.add(incidentTypeBox);

        mainPanel.add(new JLabel("Crime Category:"));
        mainPanel.add(crimeCategoryBox);

        mainPanel.add(new JLabel("Date:"));
        mainPanel.add(dateField);

        mainPanel.add(new JLabel("Time:"));
        mainPanel.add(timeField);

        mainPanel.add(new JLabel("Place:"));
        mainPanel.add(placeField);

        mainPanel.add(new JLabel("Description:"));
        mainPanel.add(new JScrollPane(descriptionArea));

        mainPanel.add(new JLabel("Suspect Info:"));
        mainPanel.add(suspectField);

        mainPanel.add(new JLabel("Victim Info:"));
        mainPanel.add(victimField);

        mainPanel.add(new JLabel("Witness Info:"));
        mainPanel.add(witnessField);

        mainPanel.add(new JLabel("Evidence File:"));
        mainPanel.add(evidenceField);

        mainPanel.add(new JLabel(""));
        mainPanel.add(uploadButton);

        mainPanel.add(new JLabel("Consent 1:"));
        mainPanel.add(accuracyCheck);

        mainPanel.add(new JLabel("Consent 2:"));
        mainPanel.add(falseReportCheck);

        mainPanel.add(new JLabel("Consent 3:"));
        mainPanel.add(privacyCheck);

        mainPanel.add(new JLabel(""));
        mainPanel.add(submitButton);

        add(mainPanel);
        setVisible(true);
    }

    private void chooseEvidenceFile() {
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            evidenceField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void submitReport() {
        String incidentType = incidentTypeBox.getSelectedItem().toString();
        String crimeCategory = crimeCategoryBox.getSelectedItem().toString();
        String date = dateField.getText();
        String time = timeField.getText();
        String place = placeField.getText();
        String description = descriptionArea.getText();

        if (date.isEmpty() || time.isEmpty() || place.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields.");
            return;
        }

        if (!accuracyCheck.isSelected() || !falseReportCheck.isSelected() || !privacyCheck.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please accept all consent conditions.");
            return;
        }

        String caseId = ReportService.generateCaseId();

        CrimeReport report = new CrimeReport(
                caseId,
                incidentType,
                crimeCategory,
                date,
                time,
                place,
                description,
                suspectField.getText(),
                victimField.getText(),
                witnessField.getText(),
                evidenceField.getText(),
                "Submitted",
                "Not Assigned"
        );

        ReportService.saveReport(report);

        if (incidentType.equals("Emergency Incident")) {
            JOptionPane.showMessageDialog(this,
                    "Emergency Report Submitted!\n" +
                            "Case ID: " + caseId + "\n" +
                            "Nearby authority will be notified.\n" +
                            "Emergency Hotline: 999");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Report Submitted Successfully!\n" +
                            "Your Case ID: " + caseId);
        }

        dispose();
    }
}