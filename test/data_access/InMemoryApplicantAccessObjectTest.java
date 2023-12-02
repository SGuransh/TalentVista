package data_access;

import entity.Applicant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryApplicantAccessObjectTest {

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
        applicantsDAO.addApplicant(applicant);

        InMemoryApplicantAccessObject DAO2 = new InMemoryApplicantAccessObject();
        assert!(DAO2.existsApplicant("Singh025"));
        DAO2.ReadCsvToInMemory();
        assert(DAO2.existsApplicant("Singh025"));

    }

    @Test
    void getApplicantDataTest(){
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

        String data = applicantsDAO.getApplicantData("Singh025");
        assert(data.contains("Guransh Singh"));

    }

}