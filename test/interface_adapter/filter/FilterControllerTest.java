package interface_adapter.filter;

import org.junit.jupiter.api.Test;
import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInputData;

import static org.junit.jupiter.api.Assertions.*;

class FilterControllerTest {

    @Test
    void successTest() {
        FilterInputBoundary interactor = new FilterInputBoundary() {
            @Override
            public void execute(FilterInputData inputData) {
                assertEquals(inputData.getSkill(), "python");
                assertEquals(inputData.getUploadDate(), "2023-01-20");
            }
        };
        FilterController controller = new FilterController(interactor);
        controller.execute("2023-01-20", "python");
    }
}