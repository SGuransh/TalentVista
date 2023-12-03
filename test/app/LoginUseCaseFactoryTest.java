package app;

import data_access.InMemoryUserDataAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;

import static org.junit.jupiter.api.Assertions.*;

class LoginUseCaseFactoryTest {

    @Test
    void create() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        LoginUserDataAccessInterface dataAccessObject = new InMemoryUserDataAccessObject();
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, hrDashboardViewModel, dataAccessObject);
    }
}