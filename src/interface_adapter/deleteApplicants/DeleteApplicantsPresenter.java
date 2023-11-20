package interface_adapter.deleteApplicants;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import use_case.deleteApplicants.DeleteApplicantsOutputBoundary;
import use_case.deleteApplicants.DeleteApplicantsOutputData;

public class DeleteApplicantsPresenter implements DeleteApplicantsOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final ShowApplicantsViewModel showApplicantsViewModel;

    public DeleteApplicantsPresenter(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel) {
        this.showApplicantsViewModel = showApplicantsViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(DeleteApplicantsOutputData outputData) {
        ShowApplicantsState state = showApplicantsViewModel.getState();
        state.setApplicantsToDisplay(outputData.getApplicants());
        showApplicantsViewModel.setState(state);
        showApplicantsViewModel.firePropertyChanged();
    }
}
