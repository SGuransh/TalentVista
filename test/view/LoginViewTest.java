package view;

import interface_adapter.hire_applicant.HireApplicantController;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageState;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import org.junit.jupiter.api.Test;
import use_case.HireApplicantButton.HireApplicantInputBoundary;
import use_case.HireApplicantButton.HireApplicantInputData;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;
import use_case.login.LoginInteractor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {
    @Test
    void actionPerformed(){
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginState state = loginViewModel.getState();
        state.setUsername("josh");
        loginViewModel.setState(state);
        LoginInputBoundary interactor = new LoginInputBoundary() {
            @Override
            public void execute(LoginInputData loginInputData) {

            }
        };
        LoginController controller = new LoginController(interactor);

        LoginView loginView = new LoginView(loginViewModel, controller);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        JButton logIn = loginView.logIn;
        logIn.addActionListener(actionListener);
        logIn.doClick();


        JTextField usernameInputField = loginView.usernameInputField;
        KeyListener[] listeners = usernameInputField.getKeyListeners();
        KeyListener listener = listeners[0];
        char keyChar = 'A';
        int keyCode = KeyEvent.VK_UNDEFINED;
        listener.keyTyped(new KeyEvent(usernameInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener.keyPressed(new KeyEvent(usernameInputField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener.keyReleased(new KeyEvent(usernameInputField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, keyCode, keyChar));

        ActionEvent event = new ActionEvent(new Object(), 1, null);
        loginView.actionPerformed(event);

        JTextField passwordInputField = loginView.passwordInputField;
        KeyListener[] listeners2 = passwordInputField.getKeyListeners();
        KeyListener listener2 = listeners2[0];
        listener2.keyTyped(new KeyEvent(passwordInputField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener2.keyPressed(new KeyEvent(passwordInputField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, keyChar));
        listener2.keyReleased(new KeyEvent(passwordInputField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, keyCode, keyChar));
    }

    @Test
    void propertyChange1() {
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), null, new Object(), new Object());
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginState state = loginViewModel.getState();
        state.setUsernameError("error1");
        loginViewModel.setState(state);
        LoginInputBoundary interactor = new LoginInputBoundary() {
            @Override
            public void execute(LoginInputData loginInputData) {

            }
        };
        LoginController controller = new LoginController(interactor);
        LoginView loginView = new LoginView(loginViewModel, controller);
        loginViewModel.firePropertyChanged();

    }
    @Test
    void propertyChange2() {
        PropertyChangeEvent event = new PropertyChangeEvent(new Object(), null, new Object(), new Object());
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginState state = loginViewModel.getState();
        state.setPasswordError("error2");
        loginViewModel.setState(state);
        LoginInputBoundary interactor = new LoginInputBoundary() {
            @Override
            public void execute(LoginInputData loginInputData) {

            }
        };
        LoginController controller = new LoginController(interactor);
        LoginView loginView = new LoginView(loginViewModel, controller);
        loginViewModel.firePropertyChanged();

    }
}