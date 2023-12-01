package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicantTest {
    private Applicant applicant;

    @BeforeEach
    void init() {
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
    }

    @Test
    void getNameTest() {
        assertEquals("Guransh Singh", applicant.getName());
    }

    @Test
    void getIdTest() {
        assertEquals("Singh025", applicant.getId());
    }

    @Test
    void getSkillsTest() {
        ArrayList<String> skills = new ArrayList<String>();
        skills.add("python");
        skills.add("java");
        skills.add("machine learning");
        skills.add("kotlin");
        assertEquals(skills, applicant.getSkills());
    }

    @Test
    void getUploadDate() {
        assertEquals("2023-12-01", applicant.getUploadDate());
    }

    @Test
    void getContactInfo() {
        HashMap<String, String> contactInfo = new HashMap<>();
        contactInfo.put("email", "guransh.hotmail.com");
        contactInfo.put("phone", "9998887776");

        assertEquals(contactInfo, applicant.getContactInfo());
    }

    @Test
    void getPersonalURLS() {
        ArrayList<String> personal_urls = new ArrayList<>();
        personal_urls.add("linkedin.com");
        personal_urls.add("github.com");

        assertEquals(personal_urls, applicant.personal_urls());
    }

    @Test
    void getPosition() {
        assertEquals("dev", applicant.getPosition());
    }
}
