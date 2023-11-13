package entity;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ApplicantFactory{

    public Applicant create(String id, String name, HashMap<String, String> skills, int age, LocalDateTime uploadDate, HashMap<String, String> contactInfo, String linkedin, String github) {
        return new Applicant(id, name, skills, age, uploadDate, contactInfo, linkedin, github);
    }
    // Sample input 1: (1, "Guransh Singh", )
}
