package use_case.filter;

import data_access.InMemoryApplicantAccessObject;
import data_access.InMemoryEmployeeAccessObject;
import entity.Applicant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FilterInteractorTest {

    @Test
    void successTest() {
        InMemoryApplicantAccessObject userRepository = new InMemoryApplicantAccessObject();
        ArrayList<String> skills = new ArrayList<>();
        skills.add("python");
        skills.add("Java");
        HashMap<String, String> contact = new HashMap<>();
        contact.put("phone", "416");
        contact.put("email", "shahbaz@nanda.ca");
        ArrayList<String> urls = skills;
        Applicant shahbaz = new Applicant("100", "Shahbaz", skills, "2020-10-01", contact,urls, "Dev");


        ArrayList<String> skills2 = new ArrayList<>();
        skills.add("C++");
        skills.add("Git");
        HashMap<String, String> contact2 = new HashMap<>();
        contact2.put("phone", "911");
        contact2.put("email", "guransh@gmail.ca");
        ArrayList<String> urls2 = skills;
        Applicant guransh = new Applicant("200", "Guransh", skills, "2019-12-01", contact,urls, "Dev");
        userRepository.addApplicant(shahbaz);
        userRepository.addApplicant(guransh);

        FilterOutputBoundary successPresenter = new FilterOutputBoundary() {
            @Override
            public void prepareSuccessView(FilterOutputData outputData) {
                String filteredApplicants = outputData.getFilteredApplicants();
                String applicantData = userRepository.getApplicantData("100");
                assertEquals(applicantData, filteredApplicants);
            }
        };
        FilterInputBoundary interactor = new FilterInteractor(userRepository, successPresenter);
        FilterInputData inputData = new FilterInputData("2020-02-23", "Java");
        interactor.execute(inputData);
    }
}