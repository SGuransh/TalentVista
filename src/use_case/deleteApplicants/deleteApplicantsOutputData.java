package use_case.deleteApplicants;

import entity.Applicant;

import java.util.Map;

public class deleteApplicantsOutputData {
     private final Map<String, Applicant> applicants;

    public deleteApplicantsOutputData(Map<String, Applicant> applicants) {
        this.applicants = applicants;
    }

    public Map<String, Applicant> getApplicants(){
        return applicants;
    }
}
