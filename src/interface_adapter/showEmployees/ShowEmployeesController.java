package interface_adapter.showEmployees;

import use_case.showEmployees.ShowEmployeesInputBoundary;

public class ShowEmployeesController {
    final ShowEmployeesInputBoundary showEmployeesInteractor;

    public ShowEmployeesController(ShowEmployeesInputBoundary showEmployeesInteractor) {
        this.showEmployeesInteractor = showEmployeesInteractor;
    }
    public void execute(){
        showEmployeesInteractor.execute();
    }
}
