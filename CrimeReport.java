public class CrimeReport {
    private String caseId;
    private String incidentType;
    private String crimeCategory;
    private String date;
    private String time;
    private String place;
    private String description;
    private String suspectInfo;
    private String victimInfo;
    private String witnessInfo;
    private String evidencePath;
    private String status;
    private String assignedInvestigator;

    public CrimeReport(String caseId, String incidentType, String crimeCategory,
                       String date, String time, String place, String description,
                       String suspectInfo, String victimInfo, String witnessInfo,
                       String evidencePath, String status, String assignedInvestigator) {

        this.caseId = caseId;
        this.incidentType = incidentType;
        this.crimeCategory = crimeCategory;
        this.date = date;
        this.time = time;
        this.place = place;
        this.description = description;
        this.suspectInfo = suspectInfo;
        this.victimInfo = victimInfo;
        this.witnessInfo = witnessInfo;
        this.evidencePath = evidencePath;
        this.status = status;
        this.assignedInvestigator = assignedInvestigator;
    }

    public String getCaseId() {
        return caseId;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getCrimeCategory() {
        return crimeCategory;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public String getSuspectInfo() {
        return suspectInfo;
    }

    public String getVictimInfo() {
        return victimInfo;
    }

    public String getWitnessInfo() {
        return witnessInfo;
    }

    public String getEvidencePath() {
        return evidencePath;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedInvestigator() {
        return assignedInvestigator;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAssignedInvestigator(String assignedInvestigator) {
        this.assignedInvestigator = assignedInvestigator;
    }

    public String toFileString() {
        return clean(caseId) + "|" +
                clean(incidentType) + "|" +
                clean(crimeCategory) + "|" +
                clean(date) + "|" +
                clean(time) + "|" +
                clean(place) + "|" +
                clean(description) + "|" +
                clean(suspectInfo) + "|" +
                clean(victimInfo) + "|" +
                clean(witnessInfo) + "|" +
                clean(evidencePath) + "|" +
                clean(status) + "|" +
                clean(assignedInvestigator);
    }

    public static CrimeReport fromFileString(String line) {
        String[] data = line.split("\\|", -1);

        if (data.length < 13) {
            return null;
        }

        return new CrimeReport(
                data[0],
                data[1],
                data[2],
                data[3],
                data[4],
                data[5],
                data[6],
                data[7],
                data[8],
                data[9],
                data[10],
                data[11],
                data[12]
        );
    }

    private String clean(String text) {
        if (text == null) {
            return "";
        }

        return text.replace("|", " ").replace("\n", " ").replace("\r", " ");
    }
}