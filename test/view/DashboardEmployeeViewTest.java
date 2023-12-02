package view;

import interface_adapter.back.BackController;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import org.junit.jupiter.api.Test;
import use_case.back.BackInputBoundary;
import use_case.back.BackInteractor;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

class DashboardEmployeeViewTest {

    @Test
    void actionPerformed() {
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        BackInputBoundary backInteractor = new BackInputBoundary() {
            @Override
            public void execute() {

            }
        };
        BackController controller = new BackController(backInteractor);
        DashboardEmployeeView dashboardEmployeeView = new DashboardEmployeeView(showEmployeesViewModel,controller);
        JButton back= dashboardEmployeeView.back;
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };

        back.addActionListener(actionListener);
        back.doClick();

        ActionEvent event = new ActionEvent(back, 1, null);
        dashboardEmployeeView.actionPerformed(event);

    }

    @Test
    void propertyChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), null, new Object(), new Object());
        ShowEmployeesViewModel showEmployeesViewModel = new ShowEmployeesViewModel();
        BackInputBoundary backInteractor = new BackInputBoundary() {
            @Override
            public void execute() {

            }
        };
        BackController controller = new BackController(backInteractor);
        DashboardEmployeeView dashboardEmployeeView = new DashboardEmployeeView(showEmployeesViewModel,controller);
        dashboardEmployeeView.propertyChange(event);

    }
}