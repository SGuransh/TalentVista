package interface_adapter.hire_applicant;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageState;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import org.junit.jupiter.api.Test;
import use_case.HireApplicantButton.HireApplicantOutputBoundary;
import use_case.HireApplicantButton.HireApplicantOutputData;
import view.HrDashboardView;

import static org.junit.jupiter.api.Assertions.*;

class HireApplicantPresenterTest {

    @Test
    void successTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        ShowHireApplicantPageState state = new ShowHireApplicantPageState();
        HireApplicantOutputBoundary presenter = new HireApplicantPresenter(viewManagerModel, showHireApplicantPageViewModel, hrDashboardViewModel);
        assertEquals(showHireApplicantPageViewModel.getState().getEmployeeData(), state.getEmployeeData());
        presenter.prepareSuccessView(new HireApplicantOutputData("taha"));
        state.setEmployeeData("taha");
        assertEquals(showHireApplicantPageViewModel.getState().getEmployeeData(), state.getEmployeeData());
        assertEquals(viewManagerModel.getActiveView(), hrDashboardViewModel.getViewName());
    }
}