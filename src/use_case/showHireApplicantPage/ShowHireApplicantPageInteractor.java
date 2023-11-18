package use_case.showHireApplicantPage;

import entity.Applicant;

public class ShowHireApplicantPageInteractor implements ShowHireApplicantPageInputBoundary {
    final ShowHireApplicantPageOutputBoundary showCreateEmployeePagePresenter;
    final ShowHireApplicantPageDataAccessInterface applicantDataAccessObject;

    public ShowHireApplicantPageInteractor(ShowHireApplicantPageOutputBoundary showCreateEmployeePagePresenter, ShowHireApplicantPageDataAccessInterface applicantDataAccessObject) {
        this.showCreateEmployeePagePresenter = showCreateEmployeePagePresenter;
        this.applicantDataAccessObject = applicantDataAccessObject;
    }

    @Override
    public void execute(ShowHireApplicantPageInputData applicantID) {
        Applicant applicant = applicantDataAccessObject.getApplicant(applicantID.getApplicantID());
        showCreateEmployeePagePresenter.prepareSuccessView(applicant);
    }
}
