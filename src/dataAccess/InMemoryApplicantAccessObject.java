package dataAccess;

import java.util.HashMap;
import java.util.Map;

import entity.Applicant;
import use_case.resumeParsing.ResumeParsingDataAccessInterface;

public class InMemoryApplicantAccessObject implements ResumeParsingDataAccessInterface {
    private final Map<String, Applicant> applicants = new HashMap<String, Applicant>();

    @Override
    public Boolean existsApplicant(String id) {
        return applicants.containsKey(id);
    }

    @Override
    public void addApplicant(Applicant applicant) {
        if (existsApplicant(applicant.getId())) {
            return;
        }
        applicants.put(applicant.getId(), applicant);
    }

    @Override
    public Applicant getApplicant(String id) {
        if (existsApplicant(id)) {
            return applicants.get(id);
        }
        return null;
    }
}

