package interface_adapter.showEmployees;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import use_case.showEmployees.ShowEmployeesOutputData;

import static org.junit.jupiter.api.Assertions.*;

class ShowEmployeesPresenterTest {

    @Test
    void successTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        ShowEmployeesPresenter presenter = new ShowEmployeesPresenter(viewManagerModel, showEmployeesViewModel);
        presenter.prepareSuccessView(new ShowEmployeesOutputData("shahbaz"));
        ShowEmployeesState state = showEmployeesViewModel.getState();
        assertEquals(state.getEmployees(), "shahbaz");
        assertEquals(viewManagerModel.getActiveView(), showEmployeesViewModel.getViewName());
    }
}