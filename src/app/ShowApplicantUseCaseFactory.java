package app;

import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.deleteApplicants.DeleteApplicantsPresenter;
import interface_adapter.filter.FilterController;
import interface_adapter.filter.FilterPresenter;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageController;
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
import use_case.showHireApplicantPage.ShowHireApplicantPageDataAccessInterface;
import view.ShowApplicantsView;

public class ShowApplicantUseCaseFactory {

    private ShowApplicantUseCaseFactory() {
    }

    ;

    // The applicants page needs the filtering use case, the delete use case, the hiring use case, the upload applicants
    // use case

    public static ShowApplicantsView create(ShowApplicantsViewModel showApplicantsViewModel,
                                            ShowHireApplicantPageViewModel showHireApplicantPageViewModel,
                                            ShowApplicantsController showApplicantsController,
                                            ShowApplicantsState showApplicantsState,
                                            ViewManagerModel viewManagerModel,
                                            FilterUserDataAccessInterface applicantDAO
    ) {
        FilterController filterController = createFilterUseCase(viewManagerModel, showApplicantsViewModel, applicantDAO);

        DeleteApplicantsController deleteApplicantsController = createDeleteApplicantsUseCase(viewManagerModel,
                showApplicantsViewModel, (DeleteApplicantsDataAccessInterface) applicantDAO);

        ShowHireApplicantPageController showHireApplicantPageController = createShowHiringUseCase(viewManagerModel,
                showApplicantsViewModel, showHireApplicantPageViewModel, (ShowHireApplicantPageDataAccessInterface) applicantDAO);

        ResumeParsingController resumeParsingController = createResumeParsingController(viewManagerModel,
                showApplicantsViewModel, (ResumeParsingDataAccessInterface) applicantDAO);

        return new ShowApplicantsView(showApplicantsViewModel, filterController);

    }

    private static ResumeParsingController createResumeParsingController(ViewManagerModel viewManagerModel,
                                                                         ShowApplicantsViewModel showApplicantsViewModel,
                                                                         ResumeParsingDataAccessInterface applicantDAO) {
        return null;
    }

    private static ShowHireApplicantPageController createShowHiringUseCase(ViewManagerModel viewManagerModel,
                                                                           ShowApplicantsViewModel showApplicantsViewModel,
                                                                           ShowHireApplicantPageViewModel showHireApplicantPageViewModel,
                                                                           ShowHireApplicantPageDataAccessInterface applicantDAO) {
        return null;
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
