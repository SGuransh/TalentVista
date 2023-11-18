package use_case.showHireApplicantPage;

public class showHireApplicantPageInputData {
    private final String applicantID;

    public showHireApplicantPageInputData(String applicantID) {
        this.applicantID = applicantID;
    }

    public String getApplicantID(){
        return this.applicantID;
    }
}
