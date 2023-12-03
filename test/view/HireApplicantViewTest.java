package view;

import interface_adapter.hire_applicant.HireApplicantController;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageState;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import org.junit.jupiter.api.Test;
import use_case.HireApplicantButton.HireApplicantInputBoundary;
import use_case.HireApplicantButton.HireApplicantInputData;
import use_case.HireApplicantButton.HireApplicantInteractor;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HireApplicantViewTest {

    @Test
    void actionPerformed() throws AWTException {
        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();
        ShowHireApplicantPageState state = showHireApplicantPageViewModel.getState();
        state.setSalary("100");
        showHireApplicantPageViewModel.setState(state);
        HireApplicantInputBoundary interactor = new HireApplicantInputBoundary() {
            @Override
            public void execute(HireApplicantInputData inputData) {

            }
        };
        HireApplicantController controller = new HireApplicantController(interactor);

        HireApplicantView hireApplicantView = new HireApplicantView(showHireApplicantPageViewModel, controller);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        JButton hireButton = hireApplicantView.hire;
        hireButton.addActionListener(actionListener);
        hireButton.doClick();

        JTextField nameInputField = hireApplicantView.nameInputField;
        KeyListener[] listeners = nameInputField.getKeyListeners();
        KeyListener listener = listeners[0];
        char keyChar = 'A';
        int keyCode = KeyEvent.VK_UNDEFINED;
        listener.keyTyped(new KeyEvent(nameInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener.keyPressed(new KeyEvent(nameInputField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener.keyReleased(new KeyEvent(nameInputField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, keyCode, keyChar));

        ActionEvent event = new ActionEvent(new Object(), 1, null);
        hireApplicantView.actionPerformed(event);


        JTextField positionInputField = hireApplicantView.positionInputField;
        KeyListener[] listeners2 = positionInputField.getKeyListeners();
        KeyListener listener2 = listeners2[0];
        listener2.keyTyped(new KeyEvent(positionInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener2.keyPressed(new KeyEvent(positionInputField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener2.keyReleased(new KeyEvent(positionInputField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, keyCode, keyChar));

        JTextField emailField = hireApplicantView.emailInputField;
        KeyListener[] listeners3 = emailField.getKeyListeners();
        KeyListener listener3 = listeners3[0];
        listener3.keyTyped(new KeyEvent(emailField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener3.keyPressed(new KeyEvent(emailField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener3.keyReleased(new KeyEvent(emailField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, keyCode, keyChar));


        JTextField salary = hireApplicantView.salaryInputField;
        KeyListener[] listeners4 = salary.getKeyListeners();
        KeyListener listener4 = listeners4[0];
        listener4.keyTyped(new KeyEvent(salary, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener4.keyPressed(new KeyEvent(salary, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener4.keyReleased(new KeyEvent(salary, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, keyCode, keyChar));
    }

    @Test
    void propertyChange() {
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), null, new Object(), new Object());

        ShowHireApplicantPageViewModel showHireApplicantPageViewModel = new ShowHireApplicantPageViewModel();
        ShowHireApplicantPageState state = showHireApplicantPageViewModel.getState();
        state.setSalary("100");
        showHireApplicantPageViewModel.setState(state);
        HireApplicantInputBoundary interactor = new HireApplicantInputBoundary() {
            @Override
            public void execute(HireApplicantInputData inputData) {

            }
        };
        HireApplicantController controller = new HireApplicantController(interactor);

        HireApplicantView hireApplicantView = new HireApplicantView(showHireApplicantPageViewModel, controller);
        showHireApplicantPageViewModel.firePropertyChanged();



    }
}