package use_case.back;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackPresenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackTest {
    @Test
    void successTest(){
        BackOutputBoundary presenter = new BackOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                assert(Boolean.TRUE);
            }
        };

        BackInputBoundary interactor = new BackInteractor(presenter);
        interactor.execute();
    }
}
