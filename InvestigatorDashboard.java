import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class InvestigatorDashboard extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private String investigatorName;

    public InvestigatorDashboard(String investigatorName) {
        this.investigatorName = investigatorName;

        setTitle("Investigator Dashboard");
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Case ID");
        model.addColumn("Crime Category");
        model.addColumn("Place");
        model.addColumn("Description");
        model.addColumn("Status");

        table = new JTable(model);

        loadAssignedCases();

        JButton refreshButton = new JButton("Refresh");
        JButton detailsButton = new JButton("View Case Details");
        JButton statusButton = new JButton("Update Status");
        JButton logoutButton = new JButton("Logout");

        refreshButton.addActionListener(e -> loadAssignedCases());
        detailsButton.addActionListener(e -> viewDetails());
        statusButton.addActionListener(e -> updateStatus());

        logoutButton.addActionListener(e -> {
            new WelcomeFrame();
            dispose();
        });

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(refreshButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(statusButton);
        buttonPanel.add(logoutButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadAssignedCases() {
        model.setRowCount(0);

        ArrayList<CrimeReport> reports = ReportService.getAllReports();

        for (CrimeReport report : reports) {
            if (report.getAssignedInvestigator().equalsIgnoreCase(investigatorName)) {
                model.addRow(new Object[]{
                        report.getCaseId(),
                        report.getCrimeCategory(),
                        report.getPlace(),
                        report.getDescription(),
                        report.getStatus()
                });
            }
        }
    }

    private String getSelectedCaseId() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a case first.");
            return null;
        }

        return model.getValueAt(row, 0).toString();
    }

    private void viewDetails() {
        String caseId = getSelectedCaseId();

        if (caseId == null) {
            return;
        }

        CrimeReport report = ReportService.findByCaseId(caseId);

        if (report != null) {
            JOptionPane.showMessageDialog(this,
                    "Case ID: " + report.getCaseId() + "\n" +
                            "Incident Type: " + report.getIncidentType() + "\n" +
                            "Crime Category: " + report.getCrimeCategory() + "\n" +
                            "Date: " + report.getDate() + "\n" +
                            "Time: " + report.getTime() + "\n" +
                            "Place: " + report.getPlace() + "\n" +
                            "Description: " + report.getDescription() + "\n" +
                            "Suspect Info: " + report.getSuspectInfo() + "\n" +
                            "Victim Info: " + report.getVictimInfo() + "\n" +
                            "Witness Info: " + report.getWitnessInfo() + "\n" +
                            "Evidence: " + report.getEvidencePath() + "\n" +
                            "Status: " + report.getStatus()
            );
        }
    }

    private void updateStatus() {
        String caseId = getSelectedCaseId();

        if (caseId == null) {
            return;
        }

        String[] statuses = {
                "Investigation Started",
                "Evidence Requested",
                "Closed"
        };

        String newStatus = (String) JOptionPane.showInputDialog(
                this,
                "Select new status:",
                "Update Status",
                JOptionPane.QUESTION_MESSAGE,
                null,
                statuses,
                statuses[0]
        );

        if (newStatus != null) {
            boolean success = ReportService.updateCaseStatus(caseId, newStatus);

            if (success) {
                JOptionPane.showMessageDialog(this, "Status updated successfully.");
                loadAssignedCases();
            }
        }
    }
}