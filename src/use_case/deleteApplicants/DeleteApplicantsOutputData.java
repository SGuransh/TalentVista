package use_case.deleteApplicants;

public class DeleteApplicantsOutputData {
     private final String applicants;

    public DeleteApplicantsOutputData(String applicants) {
        this.applicants = applicants;
    }

    public String getApplicants(){
        return applicants;
    }
}
