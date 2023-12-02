package interface_adapter.show_hire_applicant_page;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.showHireApplicantPage.ShowHireApplicantPageOutputData;

import static org.junit.jupiter.api.Assertions.*;

class ShowHireApplicantPagePresenterTest {

    @Test
    void successTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();
        ShowHireApplicantPagePresenter presenter = new ShowHireApplicantPagePresenter(viewManagerModel, showHireApplicantPageViewModel);
        presenter.prepareSuccessView(new ShowHireApplicantPageOutputData("josh", "dev", "josh@gmail.com"));
        ShowHireApplicantPageState state = showHireApplicantPageViewModel.getState();
        assertEquals(state.getName(), "josh");
        assertEquals(state.getPosition(), "dev");
        assertEquals(state.getEmail(), "josh@gmail.com");
        assertEquals(state.getEmployeeData(), "");
        assertEquals(viewManagerModel.getActiveView(), showHireApplicantPageViewModel.getViewName());
    }
}