package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Applicant {
    private final String id;
    private final String name;
    private final ArrayList<String> skills;
    private final String uploadDate;
    private final ArrayList<String> personal_urls;
    private final HashMap<String, String> contactInfo;

    public Applicant(String id, String name, ArrayList<String> skills, String uploadDate, HashMap<String, String> contactInfo, ArrayList<String> personal_urls) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.personal_urls = personal_urls;
        this.uploadDate = uploadDate;
        this.contactInfo = contactInfo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public ArrayList<String> personal_urls() {
        return this.personal_urls;
    }

    public HashMap<String, String> getContactInfo() {
        return contactInfo;
    }
}