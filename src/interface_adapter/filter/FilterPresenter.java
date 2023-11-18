package interface_adapter.filter;

import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import use_case.filter.FilterOutputBoundary;
import use_case.filter.FilterOutputData;

public class FilterPresenter implements FilterOutputBoundary {
    public FilterPresenter(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel) {
    }

    @Override
    public void prepareSuccessView(FilterOutputData outputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
