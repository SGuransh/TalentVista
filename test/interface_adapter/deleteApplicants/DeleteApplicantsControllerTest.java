package interface_adapter.deleteApplicants;

import data_access.InMemoryApplicantAccessObject;
import entity.Applicant;
import org.junit.jupiter.api.Test;
import use_case.deleteApplicants.DeleteApplicantsInputBoundary;
import use_case.deleteApplicants.DeleteApplicantsInputData;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DeleteApplicantsControllerTest {

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
        ArrayList<String> ids = new ArrayList<>();
        ids.add("Singh025");
        ids.add("100");
        applicantsDAO.addApplicant(applicant);
        applicantsDAO.addApplicant(applicant2);
        String idString = "Singh025,100";

        DeleteApplicantsInputBoundary interactor = new DeleteApplicantsInputBoundary() {
            @Override
            public void execute(DeleteApplicantsInputData inputData) {
                assert(inputData.getApplicantIDs().contains("Singh025"));
                assert(inputData.getApplicantIDs().contains("100"));
            }
        };

        DeleteApplicantsController controller = new DeleteApplicantsController(interactor);
        controller.execute(idString);
        applicantsDAO.clearCSV();
    }
}