package app;

import data_access.InMemoryEmployeeAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import org.junit.jupiter.api.Test;
import use_case.HireApplicantButton.HireApplicantDataAccessInterface;
import view.HireApplicantView;

import static org.junit.jupiter.api.Assertions.*;

class HireApplicantUseCaseFactoryTest {

    @Test
   void successTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        HireApplicantDataAccessInterface userDataAccessObject = new InMemoryEmployeeAccessObject();
        HireApplicantView hireApplicantView = HireApplicantUseCaseFactory.create(viewManagerModel, showHireApplicantPageViewModel, hrDashboardViewModel, userDataAccessObject);
        assert (hireApplicantView instanceof HireApplicantView);
    }
}