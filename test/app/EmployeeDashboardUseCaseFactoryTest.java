package app;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import org.junit.jupiter.api.Test;
import view.DashboardEmployeeView;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDashboardUseCaseFactoryTest {

    @Test
    void successTest() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        DashboardEmployeeView dashboardEmployeeView = EmployeeDashboardUseCaseFactory.create(viewManagerModel, hrDashboardViewModel, showEmployeesViewModel);
    }

}