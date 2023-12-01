package use_case.filter;

public class FilterInputData {
    private final String skill;
    private final String uploadDate;

    public FilterInputData(String uploadDate, String skill) {
        this.skill = skill;
        this.uploadDate = uploadDate;
    }

    String getSkill(){return skill;}
    String getUploadDate(){return uploadDate;}
}
