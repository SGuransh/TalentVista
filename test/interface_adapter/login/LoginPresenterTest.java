package interface_adapter.login;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

import static org.junit.jupiter.api.Assertions.*;

class LoginPresenterTest {
    private LoginOutputBoundary presenter;
    private ViewManagerModel viewManagerModel;
    private HrDashboardViewModel hrDashboardViewModel;
    private LoginViewModel loginViewModel;
    @BeforeEach
    void init(){
        loginViewModel = new LoginViewModel();
        hrDashboardViewModel = new HrDashboardViewModel();
        viewManagerModel = new ViewManagerModel();
        presenter = new LoginPresenter(viewManagerModel, loginViewModel, hrDashboardViewModel);
    }

    @Test
    void prepareSuccessViewSuccessTest() {
        presenter.prepareSuccessView(new LoginOutputData("josh", false));
        assertEquals(viewManagerModel.getActiveView(), hrDashboardViewModel.getViewName());
    }

    @Test
    void prepareFailViewSuccessTest1() {
        presenter.prepareFailView("error1", 1);
        assertEquals(loginViewModel.getState().getUsernameError(), "error1");
        assertEquals(loginViewModel.getState().getPasswordError(), null);
    }
    @Test
    void prepareFailViewSuccessTest2() {
        presenter.prepareFailView("error2", 2);
        assertEquals(loginViewModel.getState().getPasswordError(), "error2");
        assertEquals(loginViewModel.getState().getUsernameError(), null);
    }
}