package data_access;

import entity.Applicant;
import entity.Employee;
import use_case.HireApplicantButton.HireApplicantDataAccessInterface;
import use_case.showEmployees.ShowEmployeesDataAccessInterface;

import java.io.*;
import java.util.*;

public class InMemoryEmployeeAccessObject implements HireApplicantDataAccessInterface, ShowEmployeesDataAccessInterface, Iterable<Employee> {

        private final Map<String, Employee> employees = new HashMap<String, Employee>();

    public Boolean existsEmployee(String name) {
        return employees.containsKey(name);
    }
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

    public void ReadCsvToInMemory(){
        String csvFile = "src/data_access/Employees.csv";
        String line;
        String csvSplitBy = ","; // CSV files typically use commas as separators
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String name = data[0];
                String password = data[1];
                Double salary = Double.parseDouble(data[2]);
                String position = data[3];
                String email = data[4];

                Employee employee = new Employee(name, password, null, salary, position, email);
                this.addEmployee(employee);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToCsv(){
        String csvFilePath = "src/data_access/Employees.csv";

        try {
            // Open the CSV file in append mode (this will not truncate the file)
            PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath));

            for (String key : this.employees.keySet()) {
                String lineToWrite = "";
                Employee employee = this.employees.get(key);
                lineToWrite += employee.getName() + "," + employee.getPassword() + "," + employee.getSalary().toString() + "," + employee.getPosition()+ "," + employee.getEmail();
                writer.println(lineToWrite);
            }


            // Close the writer to ensure changes are flushed and the file is released
            writer.close();
            System.out.println("CSV lines written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearCSV(){
        String csvFilePath = "src/data_access/Employees.csv";
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath));
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
