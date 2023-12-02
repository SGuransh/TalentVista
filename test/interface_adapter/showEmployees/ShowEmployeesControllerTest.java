package interface_adapter.showEmployees;

import org.junit.jupiter.api.Test;
import use_case.showEmployees.ShowEmployeesInputBoundary;

import static org.junit.jupiter.api.Assertions.*;

class ShowEmployeesControllerTest {

    @Test
    void successTest() {
        ShowEmployeesInputBoundary interactor = new ShowEmployeesInputBoundary() {
            @Override
            public void execute() {
            }
        };
        ShowEmployeesController controller = new ShowEmployeesController(interactor);
        controller.execute();
    }
}