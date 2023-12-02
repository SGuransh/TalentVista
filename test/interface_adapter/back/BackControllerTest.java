package interface_adapter.back;

import org.junit.jupiter.api.Test;
import use_case.back.BackInputBoundary;

import static org.junit.jupiter.api.Assertions.*;

class BackControllerTest {

    @Test
    void successTest(){
        BackInputBoundary interactor = new BackInputBoundary() {
            @Override
            public void execute() {
                assert(Boolean.TRUE) ;
            }
        };

        BackController controller = new BackController(interactor);
        controller.execute();
    }
}