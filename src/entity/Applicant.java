package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Applicant {
    private String id;
    private String name;
    private ArrayList<String> skills;
    private String uploadDate;
    private ArrayList<String> personal_urls;
    private HashMap<String, String> contactInfo;

//    private final Double salary;
    private String position;

    public Applicant(String id, String name, ArrayList<String> skills, String uploadDate, HashMap<String, String> contactInfo, ArrayList<String> personal_urls, String position) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.personal_urls = personal_urls;
        this.uploadDate = uploadDate;
        this.contactInfo = contactInfo;
        this.position = position;
    }

    public Applicant() {

    }

    public String getPosition(){return position;}
    public void setPosition(String position){this.position = position;}

    public String getId() {
        return id;
    }
    public void setId(String id){this.id = id;}

    public String getName() {
        return name;
    }
    public void setName(String name){this.name = name;}

    public ArrayList<String> getSkills() {
        return skills;
    }
    public void setSkills(ArrayList<String> skills){
        this.skills = skills;
    }

    public String getUploadDate() {
        return uploadDate;
    }
    public void setUploadDate(){this.uploadDate = LocalDateTime.now().toLocalDate().toString();}

    public ArrayList<String> personal_urls() {
        return this.personal_urls;
    }
    public void setPersonal_urls(ArrayList<String> urls){
        this.personal_urls = urls;
    }
    public HashMap<String, String> getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(HashMap<String, String> contacts){
        this.contactInfo = contacts;
    }

}