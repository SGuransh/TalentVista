package use_case.showHireApplicantPage;

import entity.Applicant;

public interface ShowHireApplicantPageDataAccessInterface {
    Applicant getApplicant(String id);
}
