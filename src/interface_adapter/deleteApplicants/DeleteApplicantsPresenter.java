package interface_adapter.deleteApplicants;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import use_case.deleteApplicants.deleteApplicantsOutputBoundary;
import use_case.deleteApplicants.deleteApplicantsOutputData;

public class DeleteApplicantsPresenter implements deleteApplicantsOutputBoundary {
    private final HrDashboardViewModel applicantPageViewModel;

    public DeleteApplicantsPresenter(HrDashboardViewModel applicantPageView) {
        this.applicantPageViewModel = applicantPageView;
    }

    @Override
    public void prepareSuccessView(deleteApplicantsOutputData outputData) {
        ApplicantPageState applicantPageState = applicantPageView.getState();
        applicantPageState.SetApplicants(outputData);
        applicantPageViewModel.setState(signupState);
        applicantPageViewModel.firePropertyChanged();

    }
}
