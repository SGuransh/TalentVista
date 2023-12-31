package app;

import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsPresenter;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.showEmployees.ShowEmployeesController;
import interface_adapter.showEmployees.ShowEmployeesPresenter;
import interface_adapter.showEmployees.ShowEmployeesViewModel;
import use_case.showApplicants.ShowApplicantsDataAccessInterface;
import use_case.showApplicants.ShowApplicantsInputBoundary;
import use_case.showApplicants.ShowApplicantsInteractor;
import use_case.showApplicants.ShowApplicantsOutputBoundary;
import use_case.showEmployees.ShowEmployeesDataAccessInterface;
import use_case.showEmployees.ShowEmployeesInputBoundary;
import use_case.showEmployees.ShowEmployeesInteractor;
import use_case.showEmployees.ShowEmployeesOutputBoundary;
import view.HrDashboardView;

public class HrDashboardUseCaseFactory {
    private HrDashboardUseCaseFactory() {};

    public static HrDashboardView create(ViewManagerModel viewManagerModel,
                                         HrDashboardViewModel hrDashboardViewModel,
                                         ShowEmployeesViewModel showEmployeesViewModel,
                                         ShowApplicantsViewModel showApplicantsViewModel,
                                         ShowApplicantsDataAccessInterface applicantsDataAccessObject,
                                         ShowEmployeesDataAccessInterface employeeDataAccessObject){
            ShowApplicantsController showApplicantsController = createShowApplicantsUseCase(viewManagerModel, showApplicantsViewModel, applicantsDataAccessObject);
            ShowEmployeesController showEmployeesController = createShowEmployeesUseCase(viewManagerModel, showEmployeesViewModel, employeeDataAccessObject);
            return new HrDashboardView(showApplicantsController, showEmployeesController, hrDashboardViewModel);
    }

    private static ShowApplicantsController createShowApplicantsUseCase(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel, ShowApplicantsDataAccessInterface applicantsDataAccessObject){
        ShowApplicantsOutputBoundary showApplicantsPresenter = new ShowApplicantsPresenter(showApplicantsViewModel, viewManagerModel);
        ShowApplicantsInputBoundary showApplicantsInteractor = new ShowApplicantsInteractor(showApplicantsPresenter, applicantsDataAccessObject);
        return new ShowApplicantsController(showApplicantsInteractor);

    }
    private static ShowEmployeesController createShowEmployeesUseCase(ViewManagerModel viewManagerModel, ShowEmployeesViewModel showEmployeesViewModel, ShowEmployeesDataAccessInterface employeeDataAccessObject){
        ShowEmployeesOutputBoundary showEmployeesOutputBoundary = new ShowEmployeesPresenter(viewManagerModel, showEmployeesViewModel);


        ShowEmployeesInputBoundary showEmployeesInteractor = new ShowEmployeesInteractor(
                employeeDataAccessObject, showEmployeesOutputBoundary);

        return new ShowEmployeesController(showEmployeesInteractor);
    }


}
