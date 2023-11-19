package interface_adapter.showApplicants;

public class ShowApplicantsState {
    private String applicantsToDelete = "";
    private String applicantToHire = "";
    private String dateToFilter = "";
    private String skillToFilter = null;
    private String filesToUpload = "";
    private String applicantsToDisplay = "";


    public ShowApplicantsState(ShowApplicantsState copy) {
        applicantsToDelete = copy.applicantsToDelete;
        applicantToHire = copy.applicantToHire;
        dateToFilter = copy.dateToFilter;
        skillToFilter = copy.skillToFilter;
        filesToUpload = copy.filesToUpload;
        applicantsToDisplay = copy.applicantsToDisplay;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ShowApplicantsState() {
    }

    public String getApplicantsToDelete() {
        return applicantsToDelete;
    }

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


    public void setApplicantsToDelete(String applicantsToDelete) {
        this.applicantsToDelete = applicantsToDelete;
    }

    public void setApplicantToHire(String applicantToHire) {
        this.applicantToHire = applicantToHire;
    }

    public void setDateToFilter(String dateToFilter) {
        this.dateToFilter = dateToFilter;
    }

    public void setSkillToFilter(String skillToFilter) {
        this.skillToFilter = skillToFilter;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    public void setDeletedUsers(String deletedUsers){
        this.deletedUsers = deletedUsers;
    }

    public String getDeletedUsers(){
        return this.deletedUsers;
    }
}
