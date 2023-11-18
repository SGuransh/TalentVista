package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.filter.FilterController;
import interface_adapter.showApplicants.ShowApplicantsController;
import interface_adapter.showApplicants.ShowApplicantsPresenter;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import view.ShowApplicantsView;

import javax.swing.*;
import java.io.IOException;

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
        try {
            FilterController filterController = createFilterUseCase(showApplicantsViewModel);
            DeleteApplicantsController deleteApplicantsController = createDeleteApplicantsUseCase(showApplicantsViewModel);

            return new LoginView(showApplicantsViewModel, filterController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static FilterController createFilterUseCase(ShowApplicantsViewModel showApplicantsViewModel) {

    }
}
