package dataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.Applicant;
import use_case.deleteApplicants.deleteApplicantsDataAccessInterface;
import use_case.filter.FilterUserDataAccessInterface;
import use_case.resumeParsing.ResumeParsingDataAccessInterface;
import use_case.showHireApplicantPage.showHireApplicantPageDataAccessInterface;

public class InMemoryApplicantAccessObject implements ResumeParsingDataAccessInterface, deleteApplicantsDataAccessInterface, showHireApplicantPageDataAccessInterface, FilterUserDataAccessInterface {
    private final Map<String, Applicant> applicants = new HashMap<String, Applicant>();

    @Override
    public Boolean existsApplicant(String id) {
        return applicants.containsKey(id);
    }

    @Override
    public void addApplicant(Applicant applicant) {
        if (existsApplicant(applicant.getId())) {
            return;
        }
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

    public String getPresentableApplicants(){
        StringBuilder presentableApplicants = new StringBuilder();
        for (String applicantID: applicants.keySet()){
            Map<String, Applicant> applicantMap = applicants;
            Applicant applicant = applicantMap.get(applicantID);
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
            presentableApplicants.append("ID: " + ID+ " NAME: " + name + "SKILLS: " + skillsString + "EMAIL: " + email + "PHONE: " + phoneNum);
            presentableApplicants.append("\n\n");
    }
        return presentableApplicants.toString();

    }
}

