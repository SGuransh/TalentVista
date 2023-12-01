package use_case.showHireApplicantPage;

import entity.Applicant;

public class ShowHireApplicantPageInteractor implements ShowHireApplicantPageInputBoundary {
    final ShowHireApplicantPageOutputBoundary presenter;
    final ShowHireApplicantPageDataAccessInterface applicantDataAccessObject;

    public ShowHireApplicantPageInteractor(ShowHireApplicantPageOutputBoundary presenter, ShowHireApplicantPageDataAccessInterface applicantDataAccessObject) {
        this.presenter = presenter;
        this.applicantDataAccessObject = applicantDataAccessObject;
    }

    @Override
    public void execute(ShowHireApplicantPageInputData applicantID) {
        Applicant applicant = applicantDataAccessObject.getApplicant(applicantID.getApplicantID());
        ShowHireApplicantPageOutputData outputData = new ShowHireApplicantPageOutputData(applicant.getName(), applicant.getPosition(), applicant.getContactInfo().get("email"));
        presenter.prepareSuccessView(outputData);
    }
}
