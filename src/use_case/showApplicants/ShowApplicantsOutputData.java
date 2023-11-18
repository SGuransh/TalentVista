package use_case.showApplicants;

public class ShowApplicantsOutputData {
    private final String employees;

    public ShowApplicantsOutputData(String employees) {
        this.employees = employees;
    }

    public String getEmployees(){
        return employees;
    }
}
