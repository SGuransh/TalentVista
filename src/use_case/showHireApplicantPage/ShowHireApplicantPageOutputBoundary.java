package use_case.showHireApplicantPage;

import entity.Applicant;

public interface ShowHireApplicantPageOutputBoundary {
    public void prepareSuccessView(Applicant applicant);
}
