package app;

import data_access.InMemoryApplicantAccessObject;
import data_access.InMemoryEmployeeAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsPresenter;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.showEmployees.ShowEmployeesController;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import use_case.showApplicants.*;
import view.HrDashboardView;

import javax.swing.*;
import java.io.IOException;

public class HrDashboardUseCaseFactory {
    private HrDashboardUseCaseFactory() {};

    public static HrDashboardView create(ViewManagerModel viewManagerModel, HrDashboardViewModel hrDashboardViewModel, ShowEmployeesViewModel showEmployeesViewModel, ShowApplicantsViewModel showApplicantsViewModel, ShowApplicantsDataAccessInterface applicantsDataAccessObject, InMemoryEmployeeAccessObject employeeDataAccessObject){
        try {
            ShowApplicantsController showApplicantsController = createShowApplicantsUseCase(viewManagerModel, showApplicantsViewModel, applicantsDataAccessObject);
            ShowEmployeesController showEmployeesController = createShowEmployeesUseCase(viewManagerModel, showEmployeesViewModel, employeeDataAccessObject);
            return new HrDashboardView(showApplicantsController, showEmployeesController, hrDashboardViewModel);
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Fail");

        }
        return null;
    }

    private static ShowApplicantsController createShowApplicantsUseCase(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel, ShowApplicantsDataAccessInterface applicantsDataAccessObject){
        ShowApplicantsOutputBoundary showApplicantsPresenter = new ShowApplicantsPresenter(showApplicantsViewModel, viewManagerModel);
        ShowApplicantsInputBoundary showApplicantsInteractor = new ShowApplicantsInteractor(showApplicantsPresenter, applicantsDataAccessObject);
        return new ShowApplicantsController(showApplicantsInteractor);

    }
    private static ShowEmployeesController createShowEmployeesUseCase(ViewManagerModel viewManagerModel, ShowEmployeesViewModel showEmployeesViewModel, InMemoryEmployeeAccessObject employeeDataAccessObject){

    }
}
