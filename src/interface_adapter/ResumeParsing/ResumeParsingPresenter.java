package interface_adapter.ResumeParsing;

import entity.Applicant;
import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import use_case.resumeParsing.ResumeParsingOutputBoundary;
import use_case.resumeParsing.ResumeParsingOutputData;

import java.util.ArrayList;

public class ResumeParsingPresenter implements ResumeParsingOutputBoundary {
    public final ViewManagerModel viewManagerModel;
    public final ShowApplicantsViewModel showApplicantsViewModel;

    public ResumeParsingPresenter(ViewManagerModel viewManagerModel, ShowApplicantsViewModel showApplicantsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.showApplicantsViewModel = showApplicantsViewModel;
    }


    @Override
    public void prepareSuccessView(ResumeParsingOutputData applicantData) {
//        ArrayList<Applicant> applicantsArray = applicantData.getApplicantData();
//        for (int i=0; i<=applicantsArray.size(); i++){
//
//        }
//
    }

    @Override
    public void prepareFailView(String error) {

    }
}
