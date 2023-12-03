package use_case.login;

import data_access.InMemoryUserDataAccessObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    @Test
    void successTest() {
        LoginUserDataAccessInterface dataAccessObject = new InMemoryUserDataAccessObject();
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals(user.getUsername(), "talentvista26@gmail.com");
            }

            @Override
            public void prepareFailView(String error, int errorType) {
                fail();
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(dataAccessObject, presenter);
        interactor.execute(new LoginInputData("talentvista26@gmail.com", "tvista#26"));
    }
    @Test
    void usernameFailTest(){
        LoginUserDataAccessInterface dataAccessObject = new InMemoryUserDataAccessObject();
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail();
            }

            @Override
            public void prepareFailView(String error, int errorType) {
                assertEquals(errorType, 1);
                assertEquals(error, "josh: Account does not exist.");
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(dataAccessObject, presenter);
        interactor.execute(new LoginInputData("josh", "admins"));
    }

    @Test
    void passwordFailTest(){
        LoginUserDataAccessInterface dataAccessObject = new InMemoryUserDataAccessObject();
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                fail();
            }

            @Override
            public void prepareFailView(String error, int errorType) {
                assertEquals(errorType, 2);
                assertEquals(error, "Incorrect password for admin.");
            }
        };
        LoginInputBoundary interactor = new LoginInteractor(dataAccessObject, presenter);
        interactor.execute(new LoginInputData("admin", "admins"));
    }
}