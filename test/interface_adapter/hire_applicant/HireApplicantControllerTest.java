package interface_adapter.hire_applicant;

import org.junit.jupiter.api.Test;
import use_case.HireApplicantButton.HireApplicantInputBoundary;
import use_case.HireApplicantButton.HireApplicantInputData;

import static org.junit.jupiter.api.Assertions.*;

class HireApplicantControllerTest {

    @Test
    void successTest() {
        HireApplicantInputBoundary interactor = new HireApplicantInputBoundary() {
            @Override
            public void execute(HireApplicantInputData inputData) {
                assertEquals(inputData.getName(), "josh");
                assertEquals(inputData.getSalary(), 500.0);
                assertEquals(inputData.getEmail(), "josh@gmail.com");
                assertEquals(inputData.getPosition(), "dev");
            }
        };
        HireApplicantController controller = new HireApplicantController(interactor);
        controller.execute("josh", "dev", "josh@gmail.com", 500.0);
    }
}