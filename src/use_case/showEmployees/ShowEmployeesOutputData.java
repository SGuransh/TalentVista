package use_case.showEmployees;

public class ShowEmployeesOutputData {
    final String employees;

    public ShowEmployeesOutputData(String employees) {
        this.employees = employees;
    }
    public String getEmployees(){return employees;}
}
