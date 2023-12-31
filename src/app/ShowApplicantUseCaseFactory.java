package app;
import data_access.InMemoryApplicantAccessObject;
import entity.ApplicantFactory;
import interface_adapter.HrDashboard.HrDashboardViewModel;
import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ResumeParsing.ResumeParsingPresenter;
import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackController;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.deleteApplicants.DeleteApplicantsPresenter;
import interface_adapter.filter.FilterController;
import interface_adapter.filter.FilterPresenter;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageController;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPagePresenter;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import use_case.deleteApplicants.DeleteApplicantsDataAccessInterface;
import use_case.deleteApplicants.DeleteApplicantsInputBoundary;
import use_case.deleteApplicants.DeleteApplicantsInteractor;
import use_case.deleteApplicants.DeleteApplicantsOutputBoundary;
import use_case.filter.FilterInputBoundary;
import use_case.filter.FilterInteractor;
import use_case.filter.FilterOutputBoundary;
import use_case.filter.FilterUserDataAccessInterface;
import use_case.resumeParsing.ResumeParsingDataAccessInterface;
import use_case.resumeParsing.ResumeParsingInputBoundary;
import use_case.resumeParsing.ResumeParsingInteractor;
import use_case.resumeParsing.ResumeParsingOutputBoundary;
import use_case.showHireApplicantPage.ShowHireApplicantPageDataAccessInterface;
import use_case.showHireApplicantPage.ShowHireApplicantPageInputBoundary;
import use_case.showHireApplicantPage.ShowHireApplicantPageInteractor;
import use_case.showHireApplicantPage.ShowHireApplicantPageOutputBoundary;
import view.ShowApplicantsView;

import static app.EmployeeDashboardUseCaseFactory.createBackUseCase;

public class ShowApplicantUseCaseFactory {

    private ShowApplicantUseCaseFactory() {};

    // The applicants page needs the filtering use case, the delete use case, the hiring use case, the upload applicants
    // use case

    public static ShowApplicantsView create(HrDashboardViewModel hrDashboardViewModel, ShowApplicantsViewModel showApplicantsViewModel,
                                            ShowHireApplicantPageViewModel showHireApplicantPageViewModel,
                                            ViewManagerModel viewManagerModel,
                                            InMemoryApplicantAccessObject applicantDAO)
    {
        FilterController filterController = createFilterUseCase(viewManagerModel, showApplicantsViewModel, applicantDAO);

        DeleteApplicantsController deleteApplicantsController = createDeleteApplicantsUseCase(viewManagerModel,
                showApplicantsViewModel, applicantDAO);

        ShowHireApplicantPageController showHireApplicantPageController = createShowHiringUseCase(viewManagerModel,
                showHireApplicantPageViewModel, applicantDAO);

        ResumeParsingController resumeParsingController = createResumeParsingController(viewManagerModel,
                showApplicantsViewModel, applicantDAO);
        BackController backController = createBackUseCase(viewManagerModel, hrDashboardViewModel);

        return new ShowApplicantsView(viewManagerModel, showApplicantsViewModel, filterController, deleteApplicantsController,
                showHireApplicantPageController, resumeParsingController, backController);

    }

    private static ResumeParsingController createResumeParsingController(ViewManagerModel viewManagerModel,
                                                                         ShowApplicantsViewModel showApplicantsViewModel,
                                                                         ResumeParsingDataAccessInterface applicantDAO)
    {
        // Make the Presenter
        ResumeParsingOutputBoundary resumeParsingPresenter = new ResumeParsingPresenter(viewManagerModel, showApplicantsViewModel);
        // Make the Interactor
        ApplicantFactory af = new ApplicantFactory();
        ResumeParsingInputBoundary resumeParsingInteractor = new ResumeParsingInteractor(applicantDAO,
                resumeParsingPresenter, af);
        return new ResumeParsingController(resumeParsingInteractor);
    }

    private static ShowHireApplicantPageController createShowHiringUseCase(ViewManagerModel viewManagerModel,
                                                                            ShowHireApplicantPageViewModel showHireApplicantPageViewModel,
                                                                            ShowHireApplicantPageDataAccessInterface applicantDAO)
    {
        // Make the Presenter
        ShowHireApplicantPageOutputBoundary showHireApplicantPagePresenter = new ShowHireApplicantPagePresenter(
                viewManagerModel, showHireApplicantPageViewModel);
        // Make the Interactor
        ShowHireApplicantPageInputBoundary showHireApplicantPageInteractor = new ShowHireApplicantPageInteractor(
                showHireApplicantPagePresenter, applicantDAO);
        return new ShowHireApplicantPageController(showHireApplicantPageInteractor);
    }

        private static DeleteApplicantsController createDeleteApplicantsUseCase(ViewManagerModel viewManagerModel,
            ShowApplicantsViewModel showApplicantsViewModel,
            DeleteApplicantsDataAccessInterface applicantDAO) {

        DeleteApplicantsOutputBoundary deleteApplicantsPresenter = new DeleteApplicantsPresenter(viewManagerModel, showApplicantsViewModel);
        DeleteApplicantsInputBoundary deleteApplicantsInteractor = new DeleteApplicantsInteractor(applicantDAO, deleteApplicantsPresenter);
        return new DeleteApplicantsController(deleteApplicantsInteractor);
    }

        private static FilterController createFilterUseCase(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel, FilterUserDataAccessInterface applicantDAO) {

        FilterOutputBoundary filterPresenter = new FilterPresenter(viewManagerModel,showApplicantsViewModel);
        FilterInputBoundary filterInteractor = new FilterInteractor(applicantDAO, filterPresenter);
        return new FilterController(filterInteractor);
        }
    }