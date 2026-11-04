import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReportService {
    private static final String FILE_NAME = "reports.txt";

    public static String generateCaseId() {
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return "CASE-" + date;
    }

    public static void saveReport(CrimeReport report) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(report.toFileString());
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<CrimeReport> getAllReports() {
        ArrayList<CrimeReport> reports = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return reports;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                CrimeReport report = CrimeReport.fromFileString(line);

                if (report != null) {
                    reports.add(report);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reports;
    }

    public static CrimeReport findByCaseId(String caseId) {
        ArrayList<CrimeReport> reports = getAllReports();

        for (CrimeReport report : reports) {
            if (report.getCaseId().equalsIgnoreCase(caseId)) {
                return report;
            }
        }

        return null;
    }

    public static void updateReports(ArrayList<CrimeReport> reports) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (CrimeReport report : reports) {
                bw.write(report.toFileString());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean updateCaseStatus(String caseId, String newStatus) {
        ArrayList<CrimeReport> reports = getAllReports();

        for (CrimeReport report : reports) {
            if (report.getCaseId().equalsIgnoreCase(caseId)) {
                report.setStatus(newStatus);
                updateReports(reports);
                return true;
            }
        }

        return false;
    }

    public static boolean assignInvestigator(String caseId, String investigatorName) {
        ArrayList<CrimeReport> reports = getAllReports();

        for (CrimeReport report : reports) {
            if (report.getCaseId().equalsIgnoreCase(caseId)) {
                report.setAssignedInvestigator(investigatorName);
                report.setStatus("Under Review");
                updateReports(reports);
                return true;
            }
        }

        return false;
    }
}