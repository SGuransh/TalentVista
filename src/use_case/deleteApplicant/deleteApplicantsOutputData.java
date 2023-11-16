package use_case.deleteApplicant;

import entity.Applicant;

import java.util.Map;

public class deleteApplicantsOutputData {
     final Map<String, Applicant> applicants;

    public deleteApplicantsOutputData(Map<String, Applicant> applicants) {
        this.applicants = applicants;
    }
}
