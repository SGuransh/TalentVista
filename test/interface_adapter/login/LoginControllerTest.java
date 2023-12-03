package interface_adapter.login;

import org.junit.jupiter.api.Test;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @Test
    void successTest() {
        LoginInputBoundary interactor = new LoginInputBoundary() {
            @Override
            public void execute(LoginInputData loginInputData) {
                assertEquals(loginInputData.getUsername(), "josh");
                assertEquals(loginInputData.getPassword(), "admin");
            }
        };
        LoginController controller = new LoginController(interactor);
        controller.execute("josh", "admin");
    }
}