package view;

import app.HrDashboardUseCaseFactory;
import data_access.InMemoryApplicantAccessObject;
import data_access.InMemoryEmployeeAccessObject;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import org.junit.jupiter.api.Test;
import use_case.showApplicants.ShowApplicantsDataAccessInterface;
import use_case.showEmployees.ShowEmployeesDataAccessInterface;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

class HrDashboardViewTest {

    @Test
    void successTest(){
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HrDashboardViewModel hrDashboardViewModel = new HrDashboardViewModel();
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ShowApplicantsDataAccessInterface applicantsDataAccessObject = new InMemoryApplicantAccessObject();
        ShowEmployeesDataAccessInterface employeeDataAccessObject = new InMemoryEmployeeAccessObject();
        HrDashboardView hrDashboardView = HrDashboardUseCaseFactory.create(viewManagerModel, hrDashboardViewModel, showEmployeesViewModel, showApplicantsViewModel, applicantsDataAccessObject, employeeDataAccessObject);
       JButton showEmployees = hrDashboardView.showEmployees;
        showEmployees.doClick();

        JButton showApplicants = hrDashboardView.showApplicants;
        showApplicants.doClick();
        ActionEvent event = new ActionEvent(new Object(), 5, "new Object()");
        PropertyChangeEvent event1 = new PropertyChangeEvent(new Object(), "5", new Object(), new Object());
        hrDashboardView.actionPerformed(event);
        hrDashboardView.propertyChange(event1);
        hrDashboardViewModel.firePropertyChanged();
        hrDashboardViewModel.addPropertyChangeListener(null);
    }
}