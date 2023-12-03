package interface_adapter.login;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;


public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;

    private final HrDashboardViewModel hrDashboardViewModel;

    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoginViewModel loginViewModel, HrDashboardViewModel hrDashboardViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.hrDashboardViewModel = hrDashboardViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        this.viewManagerModel.setActiveView(hrDashboardViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error, int errorType) {
        LoginState loginState = loginViewModel.getState();
        if (errorType == 1){
            loginState.setUsernameError(error);
            loginViewModel.firePropertyChanged();
        }else if (errorType == 2){
            loginState.setPasswordError(error);
            loginViewModel.firePropertyChanged();
        }

    }
}
