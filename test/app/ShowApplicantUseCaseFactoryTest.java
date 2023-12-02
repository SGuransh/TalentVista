package app;

import data_access.InMemoryApplicantAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import org.junit.jupiter.api.Test;
import view.HireApplicantView;
import view.ShowApplicantsView;

import static org.junit.jupiter.api.Assertions.*;

class ShowApplicantUseCaseFactoryTest {

    @Test
    void successTest(){
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        InMemoryApplicantAccessObject applicantDAO = new InMemoryApplicantAccessObject();

        ShowApplicantsView showApplicantsView = ShowApplicantUseCaseFactory.create(hrDashboardViewModel, showApplicantsViewModel, showHireApplicantPageViewModel, viewManagerModel, applicantDAO);
        assert(showApplicantsView instanceof ShowApplicantsView);
    }
}