package interface_adapter.show_hire_applicant_page;

import entity.Applicant;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import use_case.showHireApplicantPage.ShowHireApplicantPageOutputBoundary;

public class ShowHireApplicantPagePresenter implements ShowHireApplicantPageOutputBoundary {
    public final ViewManagerModel viewManagerModel;
    public final ShowApplicantsViewModel showApplicantsViewModel;
    public final ShowHireApplicantPageViewModel showHireApplicantPageViewModel;
    public ShowHireApplicantPagePresenter(ViewManagerModel viewManagerModel,
                                          ShowApplicantsViewModel showApplicantsViewModel,
                                          ShowHireApplicantPageViewModel showHireApplicantPageViewModel) {
        this.showApplicantsViewModel = showApplicantsViewModel;
        this.viewManagerModel = viewManagerModel;
        this.showHireApplicantPageViewModel = showHireApplicantPageViewModel;
    }

    @Override
    public void prepareSuccessView(Applicant applicant) {

    }
}
