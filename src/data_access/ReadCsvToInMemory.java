package data_access;

import entity.Applicant;
import entity.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReadCsvToInMemory {

    private String filePath;
    private InMemoryApplicantAccessObject applicantDAO = null;
    private InMemoryEmployeeAccessObject employeeDAO = null;


    ReadCsvToInMemory(String filePath, InMemoryApplicantAccessObject applicantDAO){
        this.filePath = filePath;
        this.applicantDAO = applicantDAO;
    }

    ReadCsvToInMemory (String filePath, InMemoryEmployeeAccessObject employeeDAO){
        this.filePath = filePath;
        this.employeeDAO = employeeDAO;
    }
    public void ReadCsvToInMemoryOperation(){
        if(applicantDAO==null){
            ReadCsvToMemoryEmployees();
        }else{
            ReadCsvToInMemoryApplicants();
        }
    }
   private  void ReadCsvToInMemoryApplicants() {
         String csvFile = filePath;
        String line;
        String csvSplitBy = ","; // CSV files typically use commas as separators
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                line = line.trim();
                String[] data = line.split(csvSplitBy);
                if (data.length < 6) {
                    break;
                }
                String id = data[0];
                String name = data[1];
                String skillsString = data[2];
                String uploadDate = data[3];
                String personal_urls_String = data[4];
                String contactInfo_String = data[5];
                String position = data[6].trim();

                skillsString = skillsString.replace("\u0016", ",").trim();
                String[] skillsArray = skillsString.substring(1, skillsString.length() - 1).split(", ");

                personal_urls_String = personal_urls_String.replace("\u0016", ",").trim();
                String[] urls_array = personal_urls_String.substring(1, personal_urls_String.length() - 1).split(",");

                contactInfo_String = contactInfo_String.replace("\u0016", ",");
                // Convert the array to an ArrayList
                ArrayList<String> skillsArrayList = new ArrayList<>(Arrays.asList(skillsArray));
                //Converting URLS to HashMap
                ArrayList<String> UrlsArrayList = new ArrayList<>(Arrays.asList(urls_array));
                //Converting URLS to HashMap

                //Converting Contacts to HashMap
                String[] contacts_String_noBracket = contactInfo_String.substring(1, contactInfo_String.length() - 1).split(", ");

                HashMap<String, String> contacts_map = new HashMap<>();

                for (String pair : contacts_String_noBracket) {
                    String[] entry = pair.split("=");
                    contacts_map.put(entry[0], entry[1]);
                }
                //Converting Contacts to HashMap

                Applicant applicant = new Applicant(id, name, skillsArrayList, uploadDate, contacts_map, UrlsArrayList, position);
                this.applicantDAO.addApplicant(applicant);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ReadCsvToMemoryEmployees(){
        String csvFile = filePath;
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
                this.employeeDAO.addEmployee(employee);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
