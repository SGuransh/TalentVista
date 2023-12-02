package interface_adapter.ResumeParsing;

import org.junit.jupiter.api.Test;
import use_case.resumeParsing.ResumeParsingInputBoundary;
import use_case.resumeParsing.ResumeParsingInputData;

import static org.junit.jupiter.api.Assertions.*;

class ResumeParsingControllerTest {

    @Test
    void successTest() {
        ResumeParsingInputBoundary interactor = new ResumeParsingInputBoundary() {
            @Override
            public void execute(ResumeParsingInputData inputData) {
                assertEquals("path", inputData.getPath());
                assertEquals("dev", inputData.getPosition());
            }
        };

        ResumeParsingController controller = new ResumeParsingController(interactor);
        controller.execute("path", "dev");
    }
}