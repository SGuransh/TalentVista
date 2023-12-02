package use_case.resumeParsing;
import entity.Applicant;

public interface ResumeParsingDataAccessInterface {
    Boolean existsApplicant(String id);
    Applicant getApplicant(String id);
    void addApplicant(Applicant applicant);
    Integer getId();

    public String getPresentableApplicants();
    void clearCSV();
}
