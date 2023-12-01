package app;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.hire_applicant.HireApplicantController;
import interface_adapter.hire_applicant.HireApplicantPresenter;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import use_case.HireApplicantButton.*;
import view.HireApplicantView;

import javax.swing.*;
import java.io.IOException;

public class HireApplicantUseCaseFactory {
    private HireApplicantUseCaseFactory() {}

    public static HireApplicantView create(
            ViewManagerModel viewManagerModel,
            ShowHireApplicantPageViewModel showHireApplicantPageViewModel,
            HrDashboardViewModel hrDashboardViewModel,
            HireApplicantDataAccessInterface userDataAccessObject) {

        try {
            HireApplicantController hireApplicantController = createHireApplicantUseCase(viewManagerModel, showHireApplicantPageViewModel, hrDashboardViewModel, userDataAccessObject);
            return new HireApplicantView(showHireApplicantPageViewModel, hireApplicantController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static HireApplicantController createHireApplicantUseCase(
            ViewManagerModel viewManagerModel,
            ShowHireApplicantPageViewModel showHireApplicantPageViewModel,
            HrDashboardViewModel hrDashboardViewModel,
            HireApplicantDataAccessInterface userDataAccessObject) throws IOException {

        HireApplicantOutputBoundary hireApplicantOutputBoundary = new HireApplicantPresenter(viewManagerModel, showHireApplicantPageViewModel, hrDashboardViewModel);
        AutoMailSend mailSender = new AutoMailSend();

        HireApplicantInputBoundary hireApplicantInteractor = new HireApplicantInteractor(
                userDataAccessObject, mailSender, hireApplicantOutputBoundary);

        return new HireApplicantController(hireApplicantInteractor);
    }
}
