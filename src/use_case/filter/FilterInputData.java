package use_case.filter;

public class FilterInputData {
    private final String skill;
    private final String uploadDate;

    public FilterInputData(String uploadDate, String skill) {
        this.skill = skill;
        this.uploadDate = uploadDate;
    }

    public String getSkill(){return skill;}
    public String getUploadDate(){return uploadDate;}
}
