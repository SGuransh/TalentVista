package app;

import data_access.InMemoryApplicantAccessObject;
import data_access.InMemoryEmployeeAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.Applicant;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import use_case.filter.FilterUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.showApplicants.ShowApplicantsDataAccessInterface;
import use_case.showEmployees.ShowEmployeesDataAccessInterface;
import view.*;
import app.HrDashboardUseCaseFactory;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        LoginViewModel loginViewModel = new LoginViewModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();

        ArrayList<String> skills = new ArrayList<>();
        skills.add("python");
        HashMap<String, String> contact = new HashMap<>();
        contact.put("phone", "416");
        ArrayList<String> urls = skills;
        Applicant SHAHBAZ = new Applicant("100", "Shahbaz", skills, "May", contact,urls, "Dev");
        Map<String, Applicant> TEST = new HashMap<>();
        TEST.put(SHAHBAZ.getId(), SHAHBAZ);
        InMemoryApplicantAccessObject applicantsDataAccessObject = new InMemoryApplicantAccessObject();
        applicantsDataAccessObject.addApplicant(SHAHBAZ);
        ShowEmployeesDataAccessInterface employeeDataAccessObject = new InMemoryEmployeeAccessObject();

        InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();
        userDataAccessObject.ReadCsvToInMemory();

        HrDashboardView hrDashboardView = HrDashboardUseCaseFactory.create(viewManagerModel, hrDashboardViewModel, showEmployeesViewModel, showApplicantsViewModel, applicantsDataAccessObject, employeeDataAccessObject);
        views.add(hrDashboardView, hrDashboardView.viewName);

        DashboardEmployeeView employeeView = EmployeeDashboardUseCaseFactory.create(viewManagerModel,hrDashboardViewModel,showEmployeesViewModel);
        views.add(employeeView, employeeView.viewName);

        ShowApplicantsView showApplicantsView = ShowApplicantUseCaseFactory.create(showApplicantsViewModel, showHireApplicantPageViewModel, viewManagerModel, applicantsDataAccessObject);
        views.add(showApplicantsView, showApplicantsView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, hrDashboardViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);


        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


    }
}