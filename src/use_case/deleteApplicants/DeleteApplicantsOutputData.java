package use_case.deleteApplicants;

public class DeleteApplicantsOutputData {
     private final String applicants;
     private final String recentlyDeleted;

    public DeleteApplicantsOutputData(String applicants, String recentlyDeleted) {
        this.applicants = applicants;
        this.recentlyDeleted = recentlyDeleted;
    }

    public String getApplicants(){
        return applicants;
    }
    public String getRecentlyDeleted(){return this.recentlyDeleted;}
}
