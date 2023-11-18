package use_case.showHireApplicantPage;

import entity.Applicant;

public interface ShowHireApplicantPageOutputBoundary {
    void prepareSuccessView(Applicant applicant);
}
