
package use_case.login;

public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.", 1);
        } else {
            String pwd = userDataAccessObject.get(username);
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".", 2);
            } else {
                LoginOutputData loginOutputData = new LoginOutputData(loginInputData.getUsername(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}
