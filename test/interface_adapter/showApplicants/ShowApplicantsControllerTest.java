package interface_adapter.showApplicants;

import org.junit.jupiter.api.Test;
import use_case.showApplicants.ShowApplicantsInputBoundary;

import static org.junit.jupiter.api.Assertions.*;

class ShowApplicantsControllerTest {

    @Test
    void successTest() {
        ShowApplicantsInputBoundary interactor = new ShowApplicantsInputBoundary() {
            @Override
            public void execute() {
                assert(Boolean.TRUE);
            }
        };

        ShowApplicantsController controller = new ShowApplicantsController(interactor);
        controller.execute();
    }
}