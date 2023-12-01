package use_case.showHireApplicantPage;

public class ShowHireApplicantPageOutputData {
    private final String name;
    private final String position;

    public ShowHireApplicantPageOutputData(String name, String position) {
        this.name = name;
        this.position = position;
    }
    public String getName(){return name;}
    public String getPosition(){return position;}
}
