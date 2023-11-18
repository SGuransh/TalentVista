package view;

import interface_adapter.HrDashboard.HrDashboardState;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showEmployees.ShowEmployeesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HrDashboardView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "HR Dashboard";
    private final HrDashboardViewModel hrDashboardViewModel;
    private final ShowApplicantsController showApplicantsController;

    private final ShowEmployeesController showEmployeesController;
    private final JButton showApplicants;
    private final JButton showEmployees;

    public HrDashboardView(ShowApplicantsController showApplicantsController, ShowEmployeesController showEmployeesController, HrDashboardViewModel hrDashboardViewModel) {
        this.hrDashboardViewModel = hrDashboardViewModel;
        this.showApplicantsController = showApplicantsController;
        this.showEmployeesController = showEmployeesController;

        JLabel title = new JLabel(HrDashboardViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        showApplicants = new JButton(HrDashboardViewModel.SHOW_APPLICANTS_BUTTON_LABEL);
        buttons.add(showApplicants);
        showEmployees = new JButton(HrDashboardViewModel.SHOW_EMPLOYEES_BUTTON_LABEL);
        buttons.add(showEmployees);

        showApplicants.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(showApplicants)) {
//                            HrDashboardState currentState = HrDashboardViewModel.getState();

                            showApplicantsController.execute();
                        }
                    }
                }
        );
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
