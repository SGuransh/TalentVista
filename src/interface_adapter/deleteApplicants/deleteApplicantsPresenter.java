package interface_adapter.deleteApplicants;

import interface_adapter.HrDashboard.HrDashboardState;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import use_case.deleteApplicants.deleteApplicantsOutputBoundary;
import use_case.deleteApplicants.deleteApplicantsOutputData;
import view.HrDashboardView;

public class deleteApplicantsPresenter implements deleteApplicantsOutputBoundary {
    private final HrDashboardViewModel applicantPageViewModel;

    public deleteApplicantsPresenter(HrDashboardViewModel applicantPageView) {
        this.applicantPageViewModel = applicantPageView;
    }

    @Override
    public void prepareSuccessView(deleteApplicantsOutputData outputData) {
//        //WRONG STATE --- GET GURANSH STATE
//        HrDashboardState applicantPageState = HrDashboardViewModel.getState();
//        applicantPageState.setApplicants(outputData);
//        applicantPageViewModel.setState(applicantPageState);
//        applicantPageViewModel.firePropertyChanged();

    }
}
