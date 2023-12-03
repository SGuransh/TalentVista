package data_access;

import entity.Applicant;
import use_case.deleteApplicants.DeleteApplicantsDataAccessInterface;
import use_case.filter.FilterUserDataAccessInterface;
import use_case.resumeParsing.ResumeParsingDataAccessInterface;
import use_case.showApplicants.ShowApplicantsDataAccessInterface;
import use_case.showHireApplicantPage.ShowHireApplicantPageDataAccessInterface;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class InMemoryApplicantAccessObject implements ResumeParsingDataAccessInterface, DeleteApplicantsDataAccessInterface, ShowHireApplicantPageDataAccessInterface, ShowApplicantsDataAccessInterface, FilterUserDataAccessInterface, Iterable<Applicant> {
    private final Map<String, Applicant> applicants = new HashMap<String, Applicant>();
    private Integer id = 0;

    private final String ApplicantsCsvPath = "src/data_access/Applicants.csv";

    private final String DefaultApplicantsCsvPath = "src/data_access/Default_Applicants.csv";

    private CsvOperationsFacade csvOperationsFacade =
            new CsvOperationsFacade(new ReadCsvToInMemory(ApplicantsCsvPath, this),
                    new SaveToCsv(ApplicantsCsvPath, this),
                    new ClearCSV(ApplicantsCsvPath));

    private CsvOperationsFacade defaultCsvFacade = new CsvOperationsFacade(new ReadCsvToInMemory(DefaultApplicantsCsvPath, this), null, null);

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
        saveToCsv();
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
            applicants.remove(applicantID.trim());
        }
        saveToCsv();
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
        for (Applicant applicant : this) {
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
            String uploadDate = applicant.getUploadDate();
            HTMLContent += "<h3>"+"<i>"+ ID + "</i>" + "&nbsp;&nbsp"+ "<span style=\"font-weight: normal;\">"+ name +"</span> " + "</h3>";
            HTMLContent += "<p>" + "<b>" +  "Email: "+"</b>" +email +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Phone: "+"</b>" +phoneNum +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Skills: "+"</b>" +skillsString +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Position: "+"</b>" +position +"</p>";
            HTMLContent += "<p>" + "<b>" +  "Upload Date: "+"</b>" +uploadDate +"</p>";
            HTMLContent +="<p>" + "_________________________" + "</p>";
            presentableApplicants.append(HTMLContent);
        }
        return presentableApplicants.toString();
    }

    public void ReadCsvToInMemory() {csvOperationsFacade.ReadCsvOperation();}

    public void saveToCsv(){csvOperationsFacade.saveToCsvOperation();}

    public void clearCSV(){csvOperationsFacade.clearCsvOperation();}

    public void ReadDefaultCSV() {defaultCsvFacade.ReadCsvOperation();}


    @Override
    public Iterator<Applicant> iterator() {
        return new ApplicantIterator();
    }

    class ApplicantIterator implements Iterator<Applicant>{
        private int curr;
        public ApplicantIterator(){
            curr = 0;
        }
        @Override
        public boolean hasNext() {
            return curr != applicants.size();
        }

        @Override
        public Applicant next() {
            if (this.hasNext()) {
                Set<String> set = applicants.keySet();
                String[] list = set.toArray(new String[0]);
                int prev = curr;
                curr++;
                return applicants.get(list[prev]);
            }else{
                return null;
            }
        }
    }

    public static void main(String[] args) {
        InMemoryApplicantAccessObject applicantsDAO = new InMemoryApplicantAccessObject();
        ArrayList<String> skills = new ArrayList<>();
        skills.add("apple");
        HashMap contact = new HashMap<>();
        contact.put("email", "1");
        Applicant app1 = new Applicant("1", "Shahbaz", skills, null, contact,skills, null);
        Applicant app2 = new Applicant("2", "Guransh", skills, null, contact,skills, null);
        Applicant app3 = new Applicant("3", "Taha", skills, null, contact,skills, null);
        applicantsDAO.addApplicant(app1);
        applicantsDAO.addApplicant(app2);
        applicantsDAO.addApplicant(app3);
        for(Applicant applicant: applicantsDAO){
            System.out.println(applicant.getName());
        }
    }
}


