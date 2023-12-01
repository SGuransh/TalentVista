package interface_adapter.show_hire_applicant_page;

import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import use_case.showHireApplicantPage.ShowHireApplicantPageOutputBoundary;
import use_case.showHireApplicantPage.ShowHireApplicantPageOutputData;

public class ShowHireApplicantPagePresenter implements ShowHireApplicantPageOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final ShowHireApplicantPageViewModel showHireApplicantPageViewModel;
    private final ShowApplicantsViewModel showApplicantsViewModel;

    public ShowHireApplicantPagePresenter(ViewManagerModel viewManagerModel,
                                          ShowApplicantsViewModel showApplicantsViewModel,
                                          ShowHireApplicantPageViewModel showHireApplicantPageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.showApplicantsViewModel = showApplicantsViewModel;
        this.showHireApplicantPageViewModel = showHireApplicantPageViewModel;
    }

    @Override
    public void prepareSuccessView(ShowHireApplicantPageOutputData outputData) {
        ShowHireApplicantPageState state = showHireApplicantPageViewModel.getState();
        state.setName(outputData.getName());
        state.setPosition(outputData.getPosition());
        state.setEmail(outputData.getEmail());
        state.setEmployeeData("");
        this.showHireApplicantPageViewModel.setState(state);
        this.showHireApplicantPageViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(showHireApplicantPageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
