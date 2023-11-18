package interface_adapter.showEmployees;

public class ShowEmployeesState {
    private String employees = "";

    public ShowEmployeesState(ShowEmployeesState copy) { employees = copy.employees;}

    public ShowEmployeesState() {}

    public String getEmployees() {
        return employees;
    }
    public void setEmployees(String employees) {
        this.employees = employees;
    }
}
