package use_case.filter;

import java.util.Date;

public class FilterInputData {
    private final String skill;
    private final String uploadDate;

    public FilterInputData(String skill, String uploadDate) {
        this.skill = skill;
        this.uploadDate = uploadDate;
    }

    String getSkill(){return skill;}
    String getUploadDate(){return uploadDate;}
}
