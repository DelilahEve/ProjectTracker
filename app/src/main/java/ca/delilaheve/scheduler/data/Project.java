package ca.delilaheve.scheduler.data;

import java.io.Serializable;

public class Project implements Serializable {

    private int projectID;

    private String projectName;
    private String quickNotes;

    private String startDate;
    private String endDate;

    public Project(int projectID, String projectName, String quickNotes, String startDate, String endDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.quickNotes = quickNotes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getQuickNotes() {
        return quickNotes;
    }
}
