package app;

import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.filter.FilterController;
import interface_adapter.hiring.HiringController;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsPresenter;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import view.ShowApplicantsView;

public class ShowApplicantUseCaseFactory {

    private ShowApplicantUseCaseFactory(){};

    // The applicants page needs the filtering use case, the delete use case, the hiring use case, the upload applicants
    // use case

    public static ShowApplicantsView create(ShowApplicantsViewModel showApplicantsViewModel,
                                            ShowApplicantsPresenter showApplicantsPresenter,
                                            ShowApplicantsController showApplicantsController,
                                            ShowApplicantsState showApplicantsState,
                                            ViewManagerModel viewManagerModel
                                            ){
        FilterController filterController = createFilterUseCase(showApplicantsViewModel);
        DeleteApplicantsController deleteApplicantsController = createDeleteApplicantsUseCase(showApplicantsViewModel);
        HiringController hiringController = createHiringUseCase();
        ResumeParsingController resumeParsingController = createResumeParsingController();

        return new ShowApplicantsView(showApplicantsViewModel, filterController);

    }

    private static ResumeParsingController createResumeParsingController() {
        return null;
    }

    private static HiringController createHiringUseCase() {
        return null;
    }

    private static DeleteApplicantsController createDeleteApplicantsUseCase(ShowApplicantsViewModel showApplicantsViewModel) {
        return null;
    }

    private static FilterController createFilterUseCase(ShowApplicantsViewModel showApplicantsViewModel) {

        return null;
    }
}
