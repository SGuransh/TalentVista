package use_case.showApplicants;

import use_case.showEmployees.ShowEmployeesDataAccessInterface;
import use_case.showEmployees.ShowEmployeesInputBoundary;
import use_case.showEmployees.ShowEmployeesOutputBoundary;
import use_case.showEmployees.ShowEmployeesOutputData;

public class ShowApplicantsInteractor implements ShowApplicantsInputBoundary {
    final ShowApplicantsDataAccessInterface applicantsDataAccessObject;
    final ShowApplicantsOutputBoundary showApplicantsPresenter;

    public ShowApplicantsInteractor(ShowApplicantsOutputBoundary showApplicantsPresenter, ShowApplicantsDataAccessInterface applicantsDataAccessObject) {
        this.applicantsDataAccessObject = applicantsDataAccessObject;
        this.showApplicantsPresenter = showApplicantsPresenter;
    }

    @Override
    public void execute() {
        String applicants = applicantsDataAccessObject.getPresentableApplicants();
        ShowApplicantsOutputData outputData = new ShowApplicantsOutputData(applicants);
        showApplicantsPresenter.prepareSuccessView(outputData);
    }
}
