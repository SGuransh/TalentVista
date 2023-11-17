package interface_adapter.deleteApplicants;

import use_case.deleteApplicants.deleteApplicantsOutputBoundary;
import use_case.deleteApplicants.deleteApplicantsOutputData;

public class deleteApplicantsPresenter implements deleteApplicantsOutputBoundary {
    private final DashboardHrApplicantsViewModel applicantPageViewModel;

    public deleteApplicantsPresenter(DashboardHrApplicantsViewModel applicantPageView) {
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
