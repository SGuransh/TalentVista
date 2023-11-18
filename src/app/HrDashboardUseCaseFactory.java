package app;

import dataAccess.InMemoryApplicantAccessObject;
import dataAccess.InMemoryEmployeeAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.showEmployees.ShowEmployeesController;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import view.HrDashboardView;

import javax.swing.*;
import java.io.IOException;

public class HrDashboardUseCaseFactory {
    private HrDashboardUseCaseFactory() {};

    public static HrDashboardView create(ViewManagerModel viewManagerModel, HrDashboardViewModel hrDashboardViewModel, ShowEmployeesViewModel showEmployeesViewModel, ShowApplicantsViewModel showApplicantsViewModel, InMemoryApplicantAccessObject applicantsDataAccessObject, InMemoryEmployeeAccessObject employeeDataAccessObject){
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

    private static ShowApplicantsController createShowApplicantsUseCase(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel, InMemoryApplicantAccessObject applicantsDataAccessObject){


    }
    private static ShowEmployeesController createShowEmployeesUseCase(ViewManagerModel viewManagerModel, ShowEmployeesViewModel showEmployeesViewModel, InMemoryEmployeeAccessObject employeeDataAccessObject){

    }
}