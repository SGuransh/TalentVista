package view;

import interface_adapter.hire_applicant.HireApplicantController;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageState;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HireApplicantView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Hire Applicant";
    private final ShowHireApplicantPageViewModel showHireApplicantPageViewModel;

    final JTextField nameInputField = new JTextField(15);

    final JTextField positionInputField = new JTextField(15);
    final JTextField emailInputField = new JTextField(30);
    final JTextField salaryInputField = new JTextField(15);

    final JButton hire;
    private final HireApplicantController hireApplicantController;

    public HireApplicantView(ShowHireApplicantPageViewModel showHireApplicantPageViewModel, HireApplicantController controller) {

        this.hireApplicantController = controller;
        this.showHireApplicantPageViewModel = showHireApplicantPageViewModel;
        this.showHireApplicantPageViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Hire Applicant Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Name"), nameInputField);
        LabelTextPanel positionInfo = new LabelTextPanel(
                new JLabel("Position"), positionInputField);
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel("Email"), emailInputField);
        LabelTextPanel salaryInfo = new LabelTextPanel(
                new JLabel("Salary"), salaryInputField);

        JPanel buttons = new JPanel();
        hire = new JButton(showHireApplicantPageViewModel.HIRE_BUTTON_LABEL);
        buttons.add(hire);


        hire.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(hire)) {
                            ShowHireApplicantPageState currentState = showHireApplicantPageViewModel.getState();

                            hireApplicantController.execute(
                                    currentState.getName(),
                                    currentState.getPosition(),
                                    currentState.getEmail(),
                                    Double.valueOf(currentState.getSalary())
                            );

                        }
                    }
                }
        );



        nameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("HELLOOOO");
                ShowHireApplicantPageState currentState = showHireApplicantPageViewModel.getState();
                currentState.setName(nameInputField.getText() + e.getKeyChar());
                showHireApplicantPageViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        positionInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowHireApplicantPageState currentState = showHireApplicantPageViewModel.getState();
                        currentState.setPosition(positionInputField.getText() + e.getKeyChar());
                        showHireApplicantPageViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        emailInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowHireApplicantPageState currentState = showHireApplicantPageViewModel.getState();
                        currentState.setEmail(emailInputField.getText() + e.getKeyChar());
                        showHireApplicantPageViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        salaryInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        ShowHireApplicantPageState currentState = showHireApplicantPageViewModel.getState();
                        currentState.setSalary(salaryInputField.getText() + e.getKeyChar());
                        showHireApplicantPageViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.add(title);
        this.add(nameInfo);
        this.add(positionInfo);
        this.add(emailInfo);
        this.add(salaryInfo);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ShowHireApplicantPageState state = (ShowHireApplicantPageState) evt.getNewValue();
        String employeeData = state.getEmployeeData();
        if (!employeeData.isEmpty()){
            JOptionPane.showMessageDialog(this, state.getEmployeeData());
        }
        nameInputField.setText(state.getName());
        positionInputField.setText(state.getPosition());
        emailInputField.setText(state.getEmail());
        salaryInputField.setText("");}

}
