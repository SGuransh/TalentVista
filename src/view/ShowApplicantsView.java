package view;

import interface_adapter.ResumeParsing.ResumeParsingController;
import interface_adapter.ViewManagerModel;
import interface_adapter.deleteApplicants.DeleteApplicantsController;
import interface_adapter.filter.FilterController;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import interface_adapter.show_hire_applicant_page.ShowHireApplicantPageController;

public class ShowApplicantsView {
    public ShowApplicantsView(ShowApplicantsViewModel showApplicantsViewModel, FilterController filterController) {
    }

    public ShowApplicantsView(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel, FilterController filterController, DeleteApplicantsController deleteApplicantsController, ShowHireApplicantPageController showHireApplicantPageController, ResumeParsingController resumeParsingController) {
    }
}
