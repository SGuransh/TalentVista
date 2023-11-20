package use_case.resumeParsing;

import entity.Applicant;

import java.util.ArrayList;

public class ResumeParsingOutputData {
    final String presentableApplicants;

    public ResumeParsingOutputData(String presentableApplicants) {
        this.presentableApplicants = presentableApplicants;
    }

    public String getPresentableApplicants(){
        return this.presentableApplicants;
    }
}
