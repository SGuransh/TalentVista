package use_case.filter;

import entity.Applicant;

import java.util.ArrayList;

public class FilterOutputData {
    private final String filteredApplicants;

    public FilterOutputData(String applicants) {
        this.filteredApplicants = applicants;
    }
    public String getFilteredApplicants(){return filteredApplicants;}
}
