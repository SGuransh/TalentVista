package use_case.resumeParsing;

import data_access.InMemoryApplicantAccessObject;
import entity.ApplicantFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ResumeParsingTest {

    String LOCAL_TIME = LocalDateTime.now().toLocalDate().toString();
    @Test
    void successTestForPDF() {
        ResumeParsingInputData inputData = new ResumeParsingInputData("test/use_case/resumeParsing/testResume.pdf", "DEV");
        ResumeParsingDataAccessInterface dataAccessObject = new InMemoryApplicantAccessObject();
        dataAccessObject.clearCSV();

        // Making a fake Presenter
        ResumeParsingOutputBoundary fakePresenter = new ResumeParsingOutputBoundary() {
            @Override
            public void prepareSuccessView(ResumeParsingOutputData applicantData) {
                String ApplicantViewingString = applicantData.getPresentableApplicants();
                System.out.println("This is what we have");
                System.out.println(ApplicantViewingString);
                assert (ApplicantViewingString.contains("Shahbaz Singh"));
                assert (ApplicantViewingString.contains("Singh001"));
                assertEquals("<html><h3><i>Singh001</i>&nbsp;&nbsp<span style=\"font-weight: normal;\">Shahbaz Singh</span> </h3><p><b>Email: </b>shahbaz.nanda.1@gmail.com</p><p><b>Phone: </b>+1 416-985-2000</p><p><b>Skills: </b>3D Modeling, Agility, Algorithms, Application Programming Interface (API), Assembling, Automation, C++ (Programming Language), Call Center Management, Cascading Style Sheet, Competitiveness, Computer Science, Curiosity, Customer Relationship Management, Data Organization, Document Preparation, Document Production, Energetic, Etl Tool, File Transfer Protocol, Fitness Testing, Full Stack Software Engineering, Hypertext Markup Language, Innovation, Interface, JavaScript (Programming Language), Lead Tracking, Learning, Learning Management System, Legal Instrument, Leverage, OLE DB, PHP, Programming Language, Prototyping, Python (Programming Language), Reliability, Robotic Design, Robotics, SWOT Analysis, Sap Implementation, Search Engine Optimization, Simulations, SolidWorks, Streamline, Streamlines, Web Application, Web Scraping, WordPress, ZebraDesigner</p><p><b>Position: </b>DEV</p><p><b>Upload Date: </b>"+ LOCAL_TIME +"</p><p>_________________________</p>", ApplicantViewingString);

                String ApplicantNewString = applicantData.getPresentableApplicantsNEW();
                assertEquals("Singh001 - Shahbaz Singh\n".trim(), ApplicantNewString.trim());
            }

            @Override
            public void prepareFailView(ResumeParsingOutputData applicantData) {
                fail("Test 1 failed, a success view was expected");
            }
        };
        ApplicantFactory af = new ApplicantFactory();
        ResumeParsingInteractor interactor = new ResumeParsingInteractor(dataAccessObject, fakePresenter, af);
        interactor.execute(inputData);
        dataAccessObject.clearCSV();
    }

    @Test
    void successTestForDir() {
        ResumeParsingInputData inputData = new ResumeParsingInputData("test/use_case/resumeParsing/resumes", "DEV");
        ResumeParsingDataAccessInterface dataAccessObject = new InMemoryApplicantAccessObject();
        dataAccessObject.clearCSV();

        // Making a fake Presenter
        ResumeParsingOutputBoundary fakePresenter = new ResumeParsingOutputBoundary() {
            @Override
            public void prepareSuccessView(ResumeParsingOutputData applicantData) {
                String ApplicantViewingString = applicantData.getPresentableApplicants();
                System.out.println("This is what we have");
                System.out.println(ApplicantViewingString);
                assert (ApplicantViewingString.contains("Shahbaz Singh"));
                assert (ApplicantViewingString.contains("Singh001"));
                assertEquals("<html><h3><i>Singh001</i>&nbsp;&nbsp<span style=\"font-weight: normal;\">Shahbaz Singh</span> </h3><p><b>Email: </b>shahbaz.nanda.1@gmail.com</p><p><b>Phone: </b>+1 416-985-2000</p><p><b>Skills: </b>3D Modeling, Agility, Algorithms, Application Programming Interface (API), Assembling, Automation, C++ (Programming Language), Call Center Management, Cascading Style Sheet, Competitiveness, Computer Science, Curiosity, Customer Relationship Management, Data Organization, Document Preparation, Document Production, Energetic, Etl Tool, File Transfer Protocol, Fitness Testing, Full Stack Software Engineering, Hypertext Markup Language, Innovation, Interface, JavaScript (Programming Language), Lead Tracking, Learning, Learning Management System, Legal Instrument, Leverage, OLE DB, PHP, Programming Language, Prototyping, Python (Programming Language), Reliability, Robotic Design, Robotics, SWOT Analysis, Sap Implementation, Search Engine Optimization, Simulations, SolidWorks, Streamline, Streamlines, Web Application, Web Scraping, WordPress, ZebraDesigner</p><p><b>Position: </b>DEV</p><p><b>Upload Date: </b>" + LOCAL_TIME + "</p><p>_________________________</p>".trim(), ApplicantViewingString.trim());
            }

            @Override
            public void prepareFailView(ResumeParsingOutputData applicantData) {
                fail("Test 1 failed, a success view was expected");
            }
        };
        ApplicantFactory af = new ApplicantFactory();
        ResumeParsingInteractor interactor = new ResumeParsingInteractor(dataAccessObject, fakePresenter, af);
        interactor.execute(inputData);
        dataAccessObject.clearCSV();
    }
}