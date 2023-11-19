package interface_adapter.showApplicants;

import interface_adapter.ViewManagerModel;
import use_case.showApplicants.ShowApplicantsOutputBoundary;
import use_case.showApplicants.ShowApplicantsOutputData;

public class ShowApplicantsPresenter implements ShowApplicantsOutputBoundary {
    private final ShowApplicantsViewModel showApplicantsViewModel;
    private ViewManagerModel viewManagerModel;

    public ShowApplicantsPresenter(ShowApplicantsViewModel showApplicantsViewModel, ViewManagerModel viewManagerModel) {
        this.showApplicantsViewModel = showApplicantsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ShowApplicantsOutputData outputData) {
        System.out.println("PRESENTER RUNNING");
        String applicantsToPresent = outputData.getPresentableApplicants();
        System.out.println("OUTPUT DATA: " + outputData.getPresentableApplicants());
        ShowApplicantsState showApplicantsState = showApplicantsViewModel.getState();
        showApplicantsState.setApplicantsToDisplay(applicantsToPresent);
        this.showApplicantsViewModel.setState(showApplicantsState);
        viewManagerModel.setActiveView(showApplicantsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
//        showApplicantsViewModel.firePropertyChanged();

    }
}
