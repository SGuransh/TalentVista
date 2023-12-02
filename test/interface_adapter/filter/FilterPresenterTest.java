package interface_adapter.filter;

import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import org.junit.jupiter.api.Test;
import use_case.filter.FilterOutputBoundary;
import use_case.filter.FilterOutputData;

import static org.junit.jupiter.api.Assertions.*;

class FilterPresenterTest {

    @Test
    void successTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ShowApplicantsState state = new ShowApplicantsState();
        FilterOutputBoundary presenter = new FilterPresenter(viewManagerModel, showApplicantsViewModel);
        assertEquals(showApplicantsViewModel.getState().getFilteredApplicants(), state.getFilteredApplicants());
        presenter.prepareSuccessView(new FilterOutputData("shahbaz"));
        state.setFilteredApplicants("shahbaz");
        assertEquals(showApplicantsViewModel.getState().getFilteredApplicants(), state.getFilteredApplicants());
    }
}