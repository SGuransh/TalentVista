package interface_adapter.filter;

import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageState;
import use_case.filter.FilterOutputBoundary;
import use_case.filter.FilterOutputData;

public class FilterPresenter implements FilterOutputBoundary {
    private final ShowApplicantsViewModel showApplicantsViewModel;
    private ViewManagerModel viewManagerModel;
    public FilterPresenter(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel) {
        this.showApplicantsViewModel =showApplicantsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(FilterOutputData outputData) {
        ShowApplicantsState state = showApplicantsViewModel.getState();
        state.setFilteredApplicants(outputData.getFilteredApplicants());
        this.showApplicantsViewModel.setState(state);
        showApplicantsViewModel.firePropertyChanged();
    }

}
