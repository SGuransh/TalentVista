package interface_adapter.deleteApplicants;

import entity.Applicant;
import use_case.deleteApplicants.deleteApplicantsOutputBoundary;
import use_case.deleteApplicants.deleteApplicantsOutputData;
import view.DashboardHrApplicantsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class deleteApplicantsPresenter implements deleteApplicantsOutputBoundary {
    private final DashboardHrApplicantsViewModel applicantPageViewModel;

    public deleteApplicantsPresenter(DashboardHrApplicantsViewModel applicantPageView) {
        this.applicantPageViewModel = applicantPageView;
    }

    @Override
    public void prepareSuccessView(deleteApplicantsOutputData outputData) {
        ApplicantPageState applicantPageState = applicantPageView.getState();
        StringBuilder presentableApplicants = new StringBuilder();
        for (String applicantID: outputData.getApplicants().keySet()){
            Map<String, Applicant> applicantMap = outputData.getApplicants();
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
        applicantPageState.SetApplicants(presentableApplicants);
        applicantPageViewModel.setState(signupState);
        applicantPageViewModel.firePropertyChanged();

    }
}
