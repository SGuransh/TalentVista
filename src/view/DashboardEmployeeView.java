package view;

import interface_adapter.back.BackController;
import interface_adapter.showEmployees.ShowEmployeesState;
import interface_adapter.showEmployees.ShowEmployeesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DashboardEmployeeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Employee Dashboard";
    private final ShowEmployeesViewModel showEmployeesViewModel;
    private final BackController backController;


    JLabel employees;

    final JButton back;

    /**
     * A window with a title and a JButton.
     */
    public DashboardEmployeeView(ShowEmployeesViewModel showEmployeesViewModel, BackController controller) {
        this.showEmployeesViewModel = showEmployeesViewModel;
        this.showEmployeesViewModel.addPropertyChangeListener(this);
        this.backController = controller;

        JLabel title = new JLabel("Employees");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel employeesInfo = new JLabel("List of Employees: ");
        employees = new JLabel();

        JPanel buttons = new JPanel();
        back = new JButton(showEmployeesViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            backController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(employeesInfo);
        this.add(employees);
        this.add(buttons);
    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ShowEmployeesState state = (ShowEmployeesState) evt.getNewValue();
        employees.setText(state.getEmployees());
    }
}
