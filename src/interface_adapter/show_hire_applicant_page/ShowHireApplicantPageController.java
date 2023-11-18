package interface_adapter.show_hire_applicant_page;

import use_case.showHireApplicantPage.ShowHireApplicantPageInputBoundary;
import use_case.showHireApplicantPage.ShowHireApplicantPageInputData;

public class ShowHireApplicantPageController {
    final ShowHireApplicantPageInputBoundary showHireApplicantPageInteractor;

    public ShowHireApplicantPageController(ShowHireApplicantPageInputBoundary showHireApplicantPageInteractor) {
        this.showHireApplicantPageInteractor = showHireApplicantPageInteractor;
    }
    public void execute(String applicantID){
        ShowHireApplicantPageInputData inputData = new ShowHireApplicantPageInputData(applicantID);
        showHireApplicantPageInteractor.execute(inputData);
    }
}
