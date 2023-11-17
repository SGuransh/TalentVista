package use_case.resumeParsing;

import entity.Applicant;

import java.util.ArrayList;

public class ResumeParsingOutputData {
    final ArrayList<Applicant> applicantData;

    public ResumeParsingOutputData(ArrayList<Applicant> applicantData) {
        this.applicantData = applicantData;
    }
}
