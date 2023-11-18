package use_case.leave_request;

public class LeaveRequestInputData {
    private final String name;
    private final String startDate;
    private final String endDate;
    private final String reason;
    private final String projectName;

    public LeaveRequestInputData(String name, String startDate, String endDate, String reason, String projectName) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.projectName = projectName;
    }
    public String getName(){return name;}
    public String getStartDate(){return startDate;}
    public String getEndDate(){return endDate;}
    public String getReason(){return reason;}
    public String getProjectName(){return projectName;}
}
