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

    @Test
    void testForState(){
        ShowHireApplicantPageState state1 = new ShowHireApplicantPageState();
        state1.setEmail("emaill");
        state1.setName("LLLOOOO");
        state1.setSalary("10000");
        ShowHireApplicantPageState state2 = new ShowHireApplicantPageState(state1);
        assertEquals(state2.getSalary(), "10000");
        assertEquals(state2.getEmail(), "emaill");
        assertEquals(state2.getName(), "LLLOOOO");
    }
}