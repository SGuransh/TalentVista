package app;

import data_access.InMemoryApplicantAccessObject;
import data_access.InMemoryEmployeeAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import use_case.showApplicants.ShowApplicantsDataAccessInterface;
import use_case.showEmployees.ShowEmployeesDataAccessInterface;
import view.HrDashboardView;
import view.ViewManager;
import app.HrDashboardUseCaseFactory;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("HR DASHBOARD");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
//        LoginViewModel loginViewModel = new LoginViewModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();


        ShowApplicantsDataAccessInterface applicantsDataAccessObject = new InMemoryApplicantAccessObject();
        ShowEmployeesDataAccessInterface employeeDataAccessObject = new InMemoryEmployeeAccessObject();

        HrDashboardView hrDashboardView = HrDashboardUseCaseFactory.create(viewManagerModel, hrDashboardViewModel, showEmployeesViewModel, showApplicantsViewModel, applicantsDataAccessObject, employeeDataAccessObject);
        views.add(hrDashboardView, hrDashboardView.viewName);

//        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
//        views.add(loginView, loginView.viewName);


        viewManagerModel.setActiveView(hrDashboardView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}