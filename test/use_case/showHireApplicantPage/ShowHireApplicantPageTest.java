package use_case.showHireApplicantPage;

import data_access.InMemoryApplicantAccessObject;
import entity.Applicant;
import org.junit.jupiter.api.Test;
import use_case.showApplicants.ShowApplicantsOutputBoundary;
import use_case.showApplicants.ShowApplicantsOutputData;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ShowHireApplicantPageTest {
    @Test
    void successTeset(){
        Applicant applicant;
        InMemoryApplicantAccessObject applicantsDAO = new InMemoryApplicantAccessObject();
        applicantsDAO.clearCSV();
        ArrayList<String> skills = new ArrayList<String>();
        skills.add("python");
        skills.add("java");
        skills.add("machine learning");
        skills.add("kotlin");
        HashMap<String, String> contactInfo = new HashMap<>();
        contactInfo.put("email", "guransh.hotmail.com");
        contactInfo.put("phone", "9998887776");
        ArrayList<String> personal_urls = new ArrayList<>();
        personal_urls.add("linkedin.com");
        personal_urls.add("github.com");
        applicant = new Applicant("Singh025", "Guransh Singh", skills, "2023-12-01", contactInfo, personal_urls, "dev");
        applicantsDAO.addApplicant(applicant);

        ShowHireApplicantPageInputData inputData = new ShowHireApplicantPageInputData(applicant.getId());
        ShowHireApplicantPageOutputBoundary presenter = new ShowHireApplicantPageOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowHireApplicantPageOutputData outputData) {
                assertEquals(outputData.getName(), "Guransh Singh");
                assertEquals(outputData.getEmail(), "guransh.hotmail.com");
                assertEquals(outputData.getPosition(), "dev");
            }
        };

        ShowHireApplicantPageInputBoundary interactor = new ShowHireApplicantPageInteractor(presenter, applicantsDAO);
        interactor.execute(inputData);


    }

}
