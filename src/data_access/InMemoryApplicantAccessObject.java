package data_access;

import entity.Applicant;
import use_case.deleteApplicants.DeleteApplicantsDataAccessInterface;
import use_case.filter.FilterUserDataAccessInterface;
import use_case.resumeParsing.ResumeParsingDataAccessInterface;
import use_case.showApplicants.ShowApplicantsDataAccessInterface;
import use_case.showHireApplicantPage.ShowHireApplicantPageDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InMemoryApplicantAccessObject implements ResumeParsingDataAccessInterface, DeleteApplicantsDataAccessInterface, ShowHireApplicantPageDataAccessInterface, ShowApplicantsDataAccessInterface, FilterUserDataAccessInterface {
    private final Map<String, Applicant> applicants = new HashMap<String, Applicant>();
    private Integer id = 0;

    @Override
    public Boolean existsApplicant(String id) {
        return applicants.containsKey(id);
    }

    @Override
    public void addApplicant(Applicant applicant) {
        if (existsApplicant(applicant.getId())) {
            return;
        }
        id += 1;
        applicants.put(applicant.getId(), applicant);
    }

    @Override
    public Applicant getApplicant(String id) {
        if (existsApplicant(id)) {
            return applicants.get(id);
        }
        return null;
    }

    @Override
    public void deleteApplicants(ArrayList<String> applicantIDs) {
        for (String applicantID: applicantIDs){
            applicants.remove(applicantID);
        }
    }

    public Map<String, Applicant> getApplicants(){
        return applicants;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getApplicantData(String id){
        StringBuilder applicantData = new StringBuilder();
        Applicant applicant = getApplicant(id);
        String name = applicant.getName();
        String ID = applicant.getId();
        ArrayList<String> skillsArray = applicant.getSkills();
        StringBuilder skillsString = new StringBuilder();
        for (String skill: skillsArray){
            skillsString.append(skill).append(", ");
        }
        HashMap<String, String> contactInfo = applicant.getContactInfo();
        String email = contactInfo.get("email");
        String phoneNum = contactInfo.get("phone");
        applicantData.append("ID: " + ID+ " NAME: " + name + " SKILLS: " + skillsString + " EMAIL: " + email + " PHONE: " + phoneNum);
        applicantData.append("\n\n");
        return applicantData.toString();
    }

    public String getPresentableApplicants() {
        StringBuilder presentableApplicants = new StringBuilder();
        for (String applicantID : applicants.keySet()) {
            Map<String, Applicant> applicantMap = applicants;
            Applicant applicant = applicantMap.get(applicantID);
            String name = applicant.getName();
            String ID = applicant.getId();
            ArrayList<String> skillsArray = applicant.getSkills();
            String skillsString = "";
            for (String skill : skillsArray) {
                skillsString += skill + ", ";
            }
            skillsString = skillsString.substring(0, skillsString.length() - 2);
            HashMap<String, String> contactInfo = applicant.getContactInfo();
            String email = contactInfo.get("email");
            String phoneNum = contactInfo.get("phone");
            String position = applicant.getPosition();
            String HTMLContent = "<html>";
            HTMLContent += "<h3>"+"<i>"+ ID + "</i>" + "&nbsp;&nbsp"+ "<span style=\"font-weight: normal;\">"+ name +"</span> " + "</h3>";
            HTMLContent += "<p>" + "<b>" +  "Email: "+"</b>" +email +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Phone: "+"</b>" +phoneNum +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Skills: "+"</b>" +skillsString +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Position: "+"</b>" +position +"</p>";
            HTMLContent +="<p>" + "_________________________" + "</p>";



            presentableApplicants.append(HTMLContent);

        }
        return presentableApplicants.toString();
    }

    public void ReadCsvToInMemory() {
        String csvFile = "src/data_access/Applicants.csv";
        String line;
        String csvSplitBy = ","; // CSV files typically use commas as separators
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                String id = data[0];

                String name = data[1];
                String skillsString = data[2];
                String uploadDate = data[3];
                String personal_urls_String = data[4];
                String contactInfo_String = data[5];
                String position = data[6];

                skillsString = skillsString.replace("\u0016", ",").trim();
                String[] skillsArray = skillsString.substring(1, skillsString.length()-1).split(", ");

                personal_urls_String = personal_urls_String.replace("\u0016", ",").trim();
                String[] urls_array = personal_urls_String.substring(1, personal_urls_String.length()-1).split(",");
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
                this.addApplicant(applicant);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToCsv(){
        String csvFilePath = "src/data_access/Applicants.csv";

        try {
            // Open the CSV file in append mode (this will not truncate the file)
            PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath));

            for (String key : this.applicants.keySet()) {
                String lineToWrite = "";
                Applicant applicant = this.applicants.get(key);
                lineToWrite += applicant.getId() + "," + applicant.getName() + "," + applicant.getSkills().toString().replace(",", "\u0016") + "," + applicant.getUploadDate() + "," + applicant.personal_urls().toString().replace(",", "\u0016") + "," + applicant.getContactInfo().toString() + "," + applicant.getPosition();
                writer.println(lineToWrite);
            }

            // Close the writer to ensure changes are flushed and the file is released
            writer.close();

            System.out.println("CSV lines written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}