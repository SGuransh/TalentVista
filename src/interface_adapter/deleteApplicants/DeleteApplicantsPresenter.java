package interface_adapter.deleteApplicants;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import use_case.deleteApplicants.DeleteApplicantsOutputBoundary;
import use_case.deleteApplicants.DeleteApplicantsOutputData;

public class DeleteApplicantsPresenter implements DeleteApplicantsOutputBoundary {
    private final HrDashboardViewModel applicantPageViewModel;

    public DeleteApplicantsPresenter(HrDashboardViewModel applicantPageView) {
        this.applicantPageViewModel = applicantPageView;
    }

    @Override
    public void prepareSuccessView(DeleteApplicantsOutputData outputData) {
//        //WRONG STATE --- GET GURANSH STATE
//        HrDashboardState applicantPageState = HrDashboardViewModel.getState();
//        applicantPageState.setApplicants(outputData);
//        applicantPageViewModel.setState(applicantPageState);
//        applicantPageViewModel.firePropertyChanged();

    }
}
