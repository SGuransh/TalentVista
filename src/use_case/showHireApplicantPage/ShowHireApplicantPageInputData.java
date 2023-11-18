package use_case.showHireApplicantPage;

public class ShowHireApplicantPageInputData {
    private final String applicantID;

    public ShowHireApplicantPageInputData(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getApplicantID(){
        return this.applicantID;
    }
}
