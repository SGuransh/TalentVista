package use_case.deleteApplicants;

import entity.Applicant;

import java.util.Map;

public class deleteApplicantsOutputData {
     private final String applicants;

    public deleteApplicantsOutputData(String applicants) {
        this.applicants = applicants;
    }

    public String getApplicants(){
        return applicants;
    }
}
