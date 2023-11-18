package entity;

public class Leave {
    private final User user;
    private final String startDate;
    private final String endDate;
    private final String reason;
    private final Project project;

    public Leave(User user, String startDate, String endDate, String reason, Project project) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.project = project;
    }
    public User getEmployee(){return user;}
    public String getStartDate(){return startDate;}
    public String getEndDate(){return endDate;}
    public String getReason(){return reason;}
    public Project getProject(){return project;}
}
