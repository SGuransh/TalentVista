package use_case.back;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackPresenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackTest {
    @Test
    void successTest(){
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        String current_view = viewManagerModel.getActiveView();
        assertEquals(current_view, null);
        BackOutputBoundary presenter = new BackPresenter(hrDashboardViewModel, viewManagerModel);
        BackInputBoundary backButton = new BackInteractor(presenter);
        backButton.execute();
        assertEquals(viewManagerModel.getActiveView(), hrDashboardViewModel.getViewName());

    }
}
