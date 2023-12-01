package use_case.HireApplicantButton;

import entity.Employee;

public class HireApplicantInputData {
    private final String name;
    private final String position;
    private final String email;
    private final Double salary;

    public HireApplicantInputData(String name, String position, String email, Double salary) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }
    public String getPosition(){return position;}
    public String getEmail(){return email;}
    public Double getSalary(){return salary;}
}
