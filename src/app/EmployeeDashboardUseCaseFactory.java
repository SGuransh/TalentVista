package app;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackController;
import interface_adapter.back.BackPresenter;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import use_case.back.BackInputBoundary;
import use_case.back.BackInteractor;
import use_case.back.BackOutputBoundary;
import view.DashboardEmployeeView;

public class EmployeeDashboardUseCaseFactory {
    private EmployeeDashboardUseCaseFactory() {}

    public static DashboardEmployeeView create(ViewManagerModel viewManagerModel, HrDashboardViewModel hrDashboardViewModel, ShowEmployeesViewModel showEmployeesViewModel) {

        BackController backController = createBackUseCase(viewManagerModel, hrDashboardViewModel);
        return new DashboardEmployeeView(showEmployeesViewModel, backController);
    }

    public static BackController createBackUseCase(ViewManagerModel viewManagerModel, HrDashboardViewModel hrDashboardViewModel){
        BackOutputBoundary backOutputBoundary = new BackPresenter(hrDashboardViewModel, viewManagerModel);

        BackInputBoundary backInteractor = new BackInteractor(backOutputBoundary);

        return new BackController(backInteractor);
    }

}
