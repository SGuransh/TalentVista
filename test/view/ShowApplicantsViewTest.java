package view;

<<<<<<< HEAD
import app.*;
import data_access.InMemoryApplicantAccessObject;
import data_access.InMemoryEmployeeAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.After;

import javax.swing.*;
import java.awt.*;
=======
import org.junit.jupiter.api.Test;
>>>>>>> a69d7083ad3f7a1a4c65de8ac8518766bbc3b0f2

import static org.junit.jupiter.api.Assertions.*;

class ShowApplicantsViewTest {
<<<<<<< HEAD
    @Before
    public void setUp() {
        JFrame application = new JFrame("HR DASHBOARD");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();

        InMemoryApplicantAccessObject applicantsDataAccessObject = new InMemoryApplicantAccessObject();
        applicantsDataAccessObject.ReadDefaultCSV();
        InMemoryEmployeeAccessObject employeeDataAccessObject = new InMemoryEmployeeAccessObject();
        employeeDataAccessObject.ReadCsvToInMemory();

        HrDashboardView hrDashboardView = HrDashboardUseCaseFactory.create(viewManagerModel, hrDashboardViewModel, showEmployeesViewModel, showApplicantsViewModel, applicantsDataAccessObject, employeeDataAccessObject);
        views.add(hrDashboardView, hrDashboardView.viewName);

        DashboardEmployeeView employeeView = EmployeeDashboardUseCaseFactory.create(viewManagerModel,hrDashboardViewModel,showEmployeesViewModel);
        views.add(employeeView, employeeView.viewName);

        ShowApplicantsView showApplicantsView = ShowApplicantUseCaseFactory.create(hrDashboardViewModel, showApplicantsViewModel, showHireApplicantPageViewModel, viewManagerModel, applicantsDataAccessObject);
        views.add(showApplicantsView, showApplicantsView.viewName);

        HireApplicantView hireApplicantView = HireApplicantUseCaseFactory.create(viewManagerModel, showHireApplicantPageViewModel, hrDashboardViewModel, employeeDataAccessObject);
        views.add(hireApplicantView, hireApplicantView.viewName);

        viewManagerModel.setActiveView(hrDashboardView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

    @After
    public void tearDown() {
        // Clearing all the things in the Window
=======


    @Test
    void actionPerformed() {
//        ShowApplicantsView showApplicantsView = new ShowApplicantsView();
>>>>>>> a69d7083ad3f7a1a4c65de8ac8518766bbc3b0f2

    }

    @Test
    void propertyChange() {
    }
}