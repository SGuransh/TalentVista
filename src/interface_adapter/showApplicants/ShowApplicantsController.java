package interface_adapter.showApplicants;

import use_case.showApplicants.ShowApplicantsInputBoundary;
import use_case.showEmployees.ShowEmployeesInputBoundary;

public class ShowApplicantsController {
    final ShowApplicantsInputBoundary showApplicantsInteractor;

    public ShowApplicantsController(ShowApplicantsInputBoundary showApplicantsInteractor) {
        this.showApplicantsInteractor = showApplicantsInteractor;
    }
    public void execute(){
        showApplicantsInteractor.execute();
    }
}
