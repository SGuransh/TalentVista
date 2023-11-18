package use_case.showHireApplicantPage;

import entity.Applicant;

public interface ShowHireApplicantPageDataAccessInterface {
    public Applicant getApplicant(String id);
}
