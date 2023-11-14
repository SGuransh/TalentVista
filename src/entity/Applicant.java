package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Applicant {
    private final String id;
    private final String name;
    private final ArrayList<String> skills;
    private final int age;
    private final LocalDateTime uploadDate;
    private final String linkedin;
    private final String github;
    private final HashMap<String, String> contactInfo;

    public Applicant(String id, String name, ArrayList<String> skills, int age, LocalDateTime uploadDate, HashMap<String, String> contactInfo, String linkedin, String github) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.age = age;
        this.linkedin = linkedin;
        this.github = github;
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

    public int getAge() {
        return age;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public String getLinkedin() {
        return this.linkedin;
    }

    public String getGithub() {
        return this.github;
    }

    public HashMap<String, String> getContactInfo() {
        return contactInfo;
    }
}