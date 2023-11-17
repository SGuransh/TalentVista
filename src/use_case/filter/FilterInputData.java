package use_case.filter;

import java.util.Date;

public class FilterInputData {
    private final String skill;
    private final Date uploadDate;

    public FilterInputData(String skill, Date uploadDate) {
        this.skill = skill;
        this.uploadDate = uploadDate;
    }
}
