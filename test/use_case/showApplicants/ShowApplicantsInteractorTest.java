package use_case.showApplicants;

import data_access.InMemoryApplicantAccessObject;
import entity.Applicant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowApplicantsInteractorTest {

    @Test
    void successTest(){
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
        Applicant applicant2 = new Applicant("100", "Shahbaz", skills,"2023-12-01", contactInfo, personal_urls, "dev" );
        applicantsDAO.addApplicant(applicant);
        applicantsDAO.addApplicant(applicant2);
        ShowApplicantsOutputBoundary presenter = new ShowApplicantsOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowApplicantsOutputData outputData) {
                String applicants = outputData.getPresentableApplicants();
                assert(applicants.contains("Guransh Singh"));
                assert(applicants.contains("Shahbaz"));

            }
        };
        ShowApplicantsInputBoundary interactor = new ShowApplicantsInteractor(presenter, applicantsDAO);
        interactor.execute();
        applicantsDAO.clearCSV();
    }
}
