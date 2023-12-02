package interface_adapter.showApplicants;

import entity.Applicant;

import java.util.ArrayList;

public class ShowApplicantsState {
    private String applicantsToDelete = "";
    private String applicantToHire = "";
    private String dateToFilter = "";
    private String skillToFilter = "";
    private String filesToUpload = "";

    private String positionToUpload = "";
    private String applicantsToDisplay = "";
    private String filteredApplicants = "";


    public ShowApplicantsState(ShowApplicantsState copy) {
        applicantsToDelete = copy.applicantsToDelete;
        applicantToHire = copy.applicantToHire;
        dateToFilter = copy.dateToFilter;
        skillToFilter = copy.skillToFilter;
        filesToUpload = copy.filesToUpload;
        applicantsToDisplay = copy.applicantsToDisplay;
        filteredApplicants = copy.filteredApplicants;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ShowApplicantsState() {
    }

    public String getApplicantsToDelete() {
        return applicantsToDelete;
    }

    public String getPositionToUpload(){return positionToUpload;}

    public String getApplicantToHire() {
        return applicantToHire;
    }

    public String getDateToFilter() {
        return dateToFilter;
    }

    public String getSkillToFilter() {
        return skillToFilter;
    }

    public String getApplicantsToDisplay() {
        return applicantsToDisplay;
    }

    public String getFilesToUpload() {
        return filesToUpload;
    }
    public String getFilteredApplicants(){return filteredApplicants;}


    public void setApplicantsToDelete(String applicantsToDelete) {this.applicantsToDelete = applicantsToDelete;}

    public void setPositionToUpload(String positionToUpload){this.positionToUpload = positionToUpload;}

    public void setApplicantToHire(String applicantToHire) {
        this.applicantToHire = applicantToHire;
    }

    public void setDateToFilter(String dateToFilter) {
        this.dateToFilter = dateToFilter;
    }

    public void setSkillToFilter(String skillToFilter) {
        this.skillToFilter = skillToFilter;
    }

    public void setFilesToUpload(String filesToUpload) {
        this.filesToUpload = filesToUpload;
    }

    public void setApplicantsToDisplay(String applicantsToDisplay) {
        this.applicantsToDisplay = applicantsToDisplay;
    }

    public void setFilteredApplicants(String filteredApplicants){this.filteredApplicants = filteredApplicants;}
}
