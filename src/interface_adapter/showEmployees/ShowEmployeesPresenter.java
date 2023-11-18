package interface_adapter.showEmployees;

import interface_adapter.ViewManagerModel;
import use_case.showEmployees.ShowEmployeesOutputBoundary;
import use_case.showEmployees.ShowEmployeesOutputData;

public class ShowEmployeesPresenter implements ShowEmployeesOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final ShowEmployeesViewModel showEmployeesViewModel;

    public ShowEmployeesPresenter(ViewManagerModel viewManagerModel, ShowEmployeesViewModel showEmployeesViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.showEmployeesViewModel = showEmployeesViewModel;
    }

    @Override
    public void prepareSuccessView(ShowEmployeesOutputData outputData) {
        ShowEmployeesState showEmployeesState = showEmployeesViewModel.getState();
        showEmployeesState.setEmployees(outputData.getEmployees());
        this.showEmployeesViewModel.setState(showEmployeesState);
        this.showEmployeesViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(showEmployeesViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
