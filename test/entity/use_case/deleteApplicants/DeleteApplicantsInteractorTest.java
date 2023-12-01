package entity.use_case.deleteApplicants;

import data_access.InMemoryApplicantAccessObject;
import entity.Applicant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.deleteApplicants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteApplicantsInteractorTest {
//    private Applicant applicant;
//    private InMemoryApplicantAccessObject applicantsDAO;
    @BeforeEach
    void init() {

    }
    @Test
    void successTest(){
        Applicant applicant;
        InMemoryApplicantAccessObject applicantsDAO = new InMemoryApplicantAccessObject();
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
        applicantsDAO.addApplicant(applicant);
        applicantsDAO.addApplicant(applicant2);
        DeleteApplicantsInputData inputData = new DeleteApplicantsInputData(ids);
        DeleteApplicantsDataAccessInterface applicantsDAO_ = applicantsDAO;
        assert(applicantsDAO.existsApplicant("Singh025"));
        assert(applicantsDAO.existsApplicant("100"));
        DeleteApplicantsOutputBoundary presenter = new DeleteApplicantsOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteApplicantsOutputData outputData) {
                assert(outputData.getApplicants().contains("Guransh Singh")==Boolean.FALSE);
                assert(outputData.getApplicants().contains("Shahbaz"));

            }
        };
        DeleteApplicantsInputBoundary interactor = new DeleteApplicantsInteractor(applicantsDAO_, presenter);
        interactor.execute(inputData);
        assert(applicantsDAO.existsApplicant("Singh025")==Boolean.FALSE);
    }
}
