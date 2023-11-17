package use_case.filter;

import entity.Applicant;

import java.util.ArrayList;

public class FilterOutputData {
    private final ArrayList<Applicant> filteredApplicants;

    public FilterOutputData(ArrayList<Applicant> applicants) {
        this.filteredApplicants = applicants;
    }
}
