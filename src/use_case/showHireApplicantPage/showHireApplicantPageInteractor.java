package use_case.showHireApplicantPage;

import entity.Applicant;

public class showHireApplicantPageInteractor implements showHireApplicantPageInputBoundary {
    final showHireApplicantPageOutputBoundary showCreateEmployeePagePresenter;
    final showHireApplicantPageDataAccessInterface applicantDataAccessObject;

    public showHireApplicantPageInteractor(showHireApplicantPageOutputBoundary showCreateEmployeePagePresenter, showHireApplicantPageDataAccessInterface applicantDataAccessObject) {
        this.showCreateEmployeePagePresenter = showCreateEmployeePagePresenter;
        this.applicantDataAccessObject = applicantDataAccessObject;
    }

    @Override
    public void execute(showHireApplicantPageInputData applicantID) {
        Applicant applicant = applicantDataAccessObject.getApplicant(applicantID.getApplicantID());
        showCreateEmployeePagePresenter.prepareSuccessView(applicant);
    }
}
