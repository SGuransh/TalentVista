package app;

import data_access.InMemoryApplicantAccessObject;
import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.filter.FilterController;
import interface_adapter.hiring.HiringController;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageViewModel;
import use_case.deleteApplicants.DeleteApplicantsDataAccessInterface;
import use_case.filter.FilterUserDataAccessInterface;
import view.ShowApplicantsView;

public class ShowApplicantUseCaseFactory {

    private ShowApplicantUseCaseFactory(){};

    // The applicants page needs the filtering use case, the delete use case, the hiring use case, the upload applicants
    // use case

    public static ShowApplicantsView create(ShowApplicantsViewModel showApplicantsViewModel,
                                            ShowHireApplicantPageViewModel showHireApplicantPageViewModel,
                                            ShowApplicantsController showApplicantsController,
                                            ShowApplicantsState showApplicantsState,
                                            ViewManagerModel viewManagerModel,
                                            FilterUserDataAccessInterface applicantDAO
                                            ){
        FilterController filterController = createFilterUseCase(viewManagerModel,showApplicantsViewModel, applicantDAO);
        DeleteApplicantsController deleteApplicantsController = createDeleteApplicantsUseCase(viewManagerModel,
                showApplicantsViewModel, (DeleteApplicantsDataAccessInterface) applicantDAO);
        HiringController hiringController = createHiringUseCase(viewManagerModel, );
        ResumeParsingController resumeParsingController = createResumeParsingController();

        return new ShowApplicantsView(showApplicantsViewModel, filterController);

    }

    private static ResumeParsingController createResumeParsingController() {
        return null;
    }

    private static HiringController createHiringUseCase() {
        return null;
    }

    private static DeleteApplicantsController createDeleteApplicantsUseCase(ViewManagerModel viewManagerModel,
                                                                            ShowApplicantsViewModel showApplicantsViewModel,
                                                                            DeleteApplicantsDataAccessInterface applicantDAO) {
        return null;
    }

    private static FilterController createFilterUseCase(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel, FilterUserDataAccessInterface applicantDAO) {

        return null;
    }
}
