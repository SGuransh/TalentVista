package interface_adapter.show_hire_applicant_page;

import interface_adapter.login.LoginState;

public class ShowHireApplicantPageState {
    private String name = "";
    private String position = "";
    private String email = "";
    private String salary = "";
    private String employeeData = "";


    public ShowHireApplicantPageState(ShowHireApplicantPageState copy) {
        name = copy.name;
        position = copy.position;
        email = copy.email;
        salary = copy.salary;
        employeeData = copy.employeeData;
    }


    public ShowHireApplicantPageState() {}

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    public  String getEmail(){return email;}
    public String getEmployeeData(){return employeeData;}

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    public  void setEmail(String email){this.email = email;}
    public void setEmployeeData(String employeeData){this.employeeData = employeeData;}

}
