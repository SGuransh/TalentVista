package interface_adapter.showApplicants;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.showApplicants.ShowApplicantsOutputData;

import static org.junit.jupiter.api.Assertions.*;

class ShowApplicantsPresenterTest {

    @Test
    void successTest() {
        ShowApplicantsOutputData outputData = new ShowApplicantsOutputData("TEST");
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        String current_view = viewManagerModel.getActiveView();
        assertEquals(current_view, null);
        String applicantsToDisplay = showApplicantsViewModel.getState().getApplicantsToDisplay();
        assertEquals(applicantsToDisplay, "");

        ShowApplicantsPresenter presenter = new ShowApplicantsPresenter(showApplicantsViewModel, viewManagerModel);
        presenter.prepareSuccessView(outputData);
        assertEquals(viewManagerModel.getActiveView(), showApplicantsViewModel.getViewName());
        assertEquals(showApplicantsViewModel.getState().getApplicantsToDisplay(), "TEST");
    }
}