package data_access;

import entity.Applicant;
import entity.Employee;
import use_case.HireApplicantButton.HireApplicantDataAccessInterface;
import use_case.showEmployees.ShowEmployeesDataAccessInterface;

import java.io.*;
import java.util.*;

public class InMemoryEmployeeAccessObject implements HireApplicantDataAccessInterface, ShowEmployeesDataAccessInterface, Iterable<Employee> {

        private final Map<String, Employee> employees = new HashMap<String, Employee>();

        private final String filePath = "src/data_access/Employees.csv";

    private CsvOperationsFacade csvOperationsFacade = new CsvOperationsFacade(new ReadCsvToInMemory(filePath, this),
            new SaveToCsv(filePath, this),
            new ClearCSV(filePath));

    public Boolean existsEmployee(String name) {
        return employees.containsKey(name);
    }

    public Map<String, Employee> getEmployees(){return this.employees;}
    @Override
    public void addEmployee(Employee employee) {
        if (existsEmployee(employee.getName())) {
            return;
        }
        employees.put(employee.getName(), employee);
        saveToCsv();
    }
    @Override
    public String getEmployeeData(Employee employee){
        StringBuilder employeeData = new StringBuilder();
        String name = employee.getName();
        Double salary = employee.getSalary();
        String position = employee.getPosition();
        String email = employee.getEmail();
        employeeData.append(" NAME: " + name + ", SALARY: " + salary + ", EMAIL: " + email + ", POSITION: " + position);
        return employeeData.toString();
    }

    @Override
    public String getPresentableEmployees() {
        StringBuilder presentableEmployees = new StringBuilder();
        for (Employee employee: this){
            String name = employee.getName();
            Double salary = employee.getSalary();
            String position = employee.getPosition();
            String email = employee.getEmail();
//            presentableEmployees.append(" NAME: " + name + ", SALARY: " + salary + ", EMAIL: " + email + ", POSITION: " + position);
            String HTMLContent = "<html>";
            HTMLContent += "<h3>"+"<i>"+ name + "</i>" + "&nbsp;&nbsp";
            HTMLContent += "<p>" + "<b>" +  "Email: "+"</b>" +email +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Position: "+"</b>" +position +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Salary: "+"</b>" +salary +"</p>";
            HTMLContent +="<p>" + "____________________________________________" + "</p>";
            presentableEmployees.append(HTMLContent);
        }
        return presentableEmployees.toString();
    }

    public void ReadCsvToInMemory(){csvOperationsFacade.ReadCsvOperation();}

    public void saveToCsv(){csvOperationsFacade.saveToCsvOperation();}

    public void clearCSV(){csvOperationsFacade.clearCsvOperation();}

    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator();
    }

    class EmployeeIterator implements Iterator<Employee>{
        private int curr;
        public EmployeeIterator(){
            curr = 0;
        }
        @Override
        public boolean hasNext() {
            return curr != employees.size();

        }

        @Override
        public Employee next() {
            if (this.hasNext()) {
                Set<String> set = employees.keySet();
                String[] list = set.toArray(new String[0]);
                int prev = curr;
                curr++;
                return employees.get(list[prev]);
            }else{
                return null;
            }
        }
    }

    public static void main(String[] args) {
        InMemoryEmployeeAccessObject dao = new InMemoryEmployeeAccessObject();
        dao.addEmployee(new Employee("Shahbaz", null, null,1.0, null, null));
        for(Employee employee: dao) {
            System.out.println(employee.getName());
        }
    }
}
