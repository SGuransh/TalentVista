package use_case.resumeParsing;

import entity.Applicant;

import java.util.ArrayList;

public class ResumeParsingOutputData {
    final String presentableApplicantsNEW;
    final String presentableApplicants;

    public ResumeParsingOutputData(String presentableApplicantsNEW, String presentableApplicants) {
        this.presentableApplicantsNEW = presentableApplicantsNEW;
        this.presentableApplicants = presentableApplicants;
    }

    public String getPresentableApplicantsNEW(){
        return this.presentableApplicantsNEW;
    }

    public String getPresentableApplicants(){
        return this.presentableApplicants;
    }
}
