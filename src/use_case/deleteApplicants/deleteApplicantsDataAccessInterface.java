package use_case.deleteApplicants;

import entity.Applicant;

import java.util.ArrayList;
import java.util.Map;

public interface deleteApplicantsDataAccessInterface {
    void deleteApplicants(ArrayList<String> applicantIDs);
    Map<String, Applicant> getApplicants();

}
