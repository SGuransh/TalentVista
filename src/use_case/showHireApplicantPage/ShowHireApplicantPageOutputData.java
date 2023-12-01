package use_case.showHireApplicantPage;

public class ShowHireApplicantPageOutputData {
    private final String name;
    private final String position;

    private final String email;

    public ShowHireApplicantPageOutputData(String name, String position, String email) {
        this.name = name;
        this.position = position;
        this.email = email;
    }
    public String getName(){return name;}
    public String getPosition(){return position;}

    public String getEmail(){return  email;}
}
