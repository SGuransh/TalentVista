package use_case.filter;

import entity.Applicant;

import java.util.ArrayList;
import java.util.Map;

public class FilterInteractor implements FilterInputBoundary {
    final FilterUserDataAccessInterface userDataAccessObject;
    final FilterOutputBoundary filterPresenter;

    public FilterInteractor(FilterUserDataAccessInterface userDataAccessObject, FilterOutputBoundary filterPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.filterPresenter = filterPresenter;
    }
    @Override
    public void execute(FilterInputData inputData) {
        String skill = inputData.getSkill();
        String uploadDate = inputData.getUploadDate();
        Map<String, Applicant> applicants = userDataAccessObject.getApplicants();
        StringBuilder filteredApplicants = new StringBuilder();
        for (String name: applicants.keySet()){
            Applicant applicant = applicants.get(name);
            ArrayList<String> skills = applicant.getSkills();
            String applicantUploadDate = applicant.getUploadDate();
            if (skills.contains(skill) && applicantUploadDate.compareTo(uploadDate) >= 0){
                String applicantData = userDataAccessObject.getApplicantData(applicant.getId());
                filteredApplicants.append(applicantData);
            }
        }
        FilterOutputData outputData = new FilterOutputData(filteredApplicants.toString());
        filterPresenter.prepareSuccessView(outputData);
    }
}
