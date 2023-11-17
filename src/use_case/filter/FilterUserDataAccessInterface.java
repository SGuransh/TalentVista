package use_case.filter;

import entity.Applicant;

import java.util.ArrayList;
import java.util.Map;

public interface FilterUserDataAccessInterface {
    Map<String, Applicant> getApplicants();

}
