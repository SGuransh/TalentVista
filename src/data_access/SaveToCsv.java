package data_access;

import entity.Applicant;
import entity.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SaveToCsv implements SaveToCsvBoundary{
    private String filePath;
    private InMemoryApplicantAccessObject applicantDAO = null;
    private InMemoryEmployeeAccessObject employeeDAO = null;


    SaveToCsv(String filePath, InMemoryApplicantAccessObject applicantDAO){
        this.filePath = filePath;
        this.applicantDAO = applicantDAO;
    }

    SaveToCsv (String filePath, InMemoryEmployeeAccessObject employeeDAO){
        this.filePath = filePath;
        this.employeeDAO = employeeDAO;
    }


    private void SavetoCsvApplicants(){
        String csvFilePath = filePath;

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath));

            int i = 0;
            for (Applicant applicant: applicantDAO) {
                i++;
                String lineToWrite = "";
                lineToWrite += applicant.getId() + "," + applicant.getName() + "," + applicant.getSkills().toString().replace(",", "\u0016") + "," + applicant.getUploadDate() + "," + applicant.personal_urls().toString().replace(",", "\u0016") + "," + applicant.getContactInfo().toString().replace(",", "\u0016") + "," + applicant.getPosition();

                if(i == this.applicantDAO.getApplicants().keySet().size()){
                    writer.print(lineToWrite);
                }else{
                    writer.println(lineToWrite);
                }

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SavetoCsvEmployees(){
        String csvFilePath = filePath;
        try {
            // Open the CSV file in append mode (this will not truncate the file)
            PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath));

            for (Employee employee: employeeDAO) {
                String lineToWrite = "";
                lineToWrite += employee.getName() + "," + employee.getPassword() + "," + employee.getSalary().toString() + "," + employee.getPosition()+ "," + employee.getEmail();
                writer.println(lineToWrite);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SaveToCsvOperation() {
            if(applicantDAO==null){
                SavetoCsvEmployees();
            }else{
                SavetoCsvApplicants();
            }
    }
}


