package interface_adapter.back;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.back.BackInputBoundary;
import use_case.back.BackInteractor;
import use_case.back.BackOutputBoundary;

import static org.junit.jupiter.api.Assertions.*;

class BackPresenterTest {

    @Test
    void successTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        String current_view = viewManagerModel.getActiveView();
        assertEquals(current_view, null);
        BackOutputBoundary presenter = new BackPresenter(hrDashboardViewModel, viewManagerModel);
        presenter.prepareSuccessView();
        assertEquals(viewManagerModel.getActiveView(), hrDashboardViewModel.getViewName());
    }
}