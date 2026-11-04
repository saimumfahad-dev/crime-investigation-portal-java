import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminDashboard extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();

        model.addColumn("Case ID");
        model.addColumn("Incident Type");
        model.addColumn("Crime Category");
        model.addColumn("Place");
        model.addColumn("Status");
        model.addColumn("Investigator");

        table = new JTable(model);

        loadReports();

        JButton refreshButton = new JButton("Refresh");
        JButton assignButton = new JButton("Assign Investigator");
        JButton statusButton = new JButton("Update Status");
        JButton logoutButton = new JButton("Logout");

        refreshButton.addActionListener(e -> loadReports());
        assignButton.addActionListener(e -> assignInvestigator());
        statusButton.addActionListener(e -> updateStatus());

        logoutButton.addActionListener(e -> {
            new WelcomeFrame();
            dispose();
        });

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(refreshButton);
        buttonPanel.add(assignButton);
        buttonPanel.add(statusButton);
        buttonPanel.add(logoutButton);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadReports() {
        model.setRowCount(0);

        ArrayList<CrimeReport> reports = ReportService.getAllReports();

        for (CrimeReport report : reports) {
            model.addRow(new Object[]{
                    report.getCaseId(),
                    report.getIncidentType(),
                    report.getCrimeCategory(),
                    report.getPlace(),
                    report.getStatus(),
                    report.getAssignedInvestigator()
            });
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

    private void assignInvestigator() {
        String caseId = getSelectedCaseId();

        if (caseId == null) {
            return;
        }

        String investigator = JOptionPane.showInputDialog(this, "Enter investigator name:");

        if (investigator != null && !investigator.isEmpty()) {
            boolean success = ReportService.assignInvestigator(caseId, investigator);

            if (success) {
                JOptionPane.showMessageDialog(this, "Investigator assigned successfully.");
                loadReports();
            }
        }
    }

    private void updateStatus() {
        String caseId = getSelectedCaseId();

        if (caseId == null) {
            return;
        }

        String[] statuses = {
                "Submitted",
                "Under Review",
                "Investigation Started",
                "Evidence Requested",
                "Closed",
                "Rejected"
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
                loadReports();
            }
        }
    }
}