package interface_adapter.show_hire_applicant_page;

import org.junit.jupiter.api.Test;
import use_case.showHireApplicantPage.ShowHireApplicantPageInputBoundary;
import use_case.showHireApplicantPage.ShowHireApplicantPageInputData;

import static org.junit.jupiter.api.Assertions.*;

class ShowHireApplicantPageControllerTest {

    @Test
    void successTest() {
        ShowHireApplicantPageInputBoundary interactor = new ShowHireApplicantPageInputBoundary() {
            @Override
            public void execute(ShowHireApplicantPageInputData applicantID) {
                assertEquals(applicantID.getApplicantID(), "100");
            }
        };
        ShowHireApplicantPageController controller = new ShowHireApplicantPageController(interactor);
        controller.execute("100");
    }
}