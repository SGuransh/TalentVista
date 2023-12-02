package interface_adapter.ResumeParsing;

import interface_adapter.ViewManagerModel;
import interface_adapter.showApplicants.ShowApplicantsState;
import interface_adapter.showApplicants.ShowApplicantsViewModel;
import org.junit.jupiter.api.Test;
import use_case.resumeParsing.ResumeParsingOutputData;

import static org.junit.jupiter.api.Assertions.*;

class ResumeParsingPresenterTest {

    @Test
    void prepareSuccessView() {
        String presentableString = "<html><h3><i>Singh001</i>&nbsp;&nbsp<span style=\"font-weight: normal;\">Shahbaz Singh</span> </h3><p><b>Email: </b>shahbaz.nanda.1@gmail.com</p><p><b>Phone: </b>+1 416-985-2000</p><p><b>Skills: </b>3D Modeling, Agility, Algorithms, Application Programming Interface (API), Assembling, Automation, C++ (Programming Language), Call Center Management, Cascading Style Sheet, Competitiveness, Computer Science, Curiosity, Customer Relationship Management, Data Organization, Document Preparation, Document Production, Energetic, Etl Tool, File Transfer Protocol, Fitness Testing, Full Stack Software Engineering, Hypertext Markup Language, Innovation, Interface, JavaScript (Programming Language), Lead Tracking, Learning, Learning Management System, Legal Instrument, Leverage, OLE DB, PHP, Programming Language, Prototyping, Python (Programming Language), Reliability, Robotic Design, Robotics, SWOT Analysis, Sap Implementation, Search Engine Optimization, Simulations, SolidWorks, Streamline, Streamlines, Web Application, Web Scraping, WordPress, ZebraDesigner</p><p><b>Position: </b>DEV</p><p>_________________________</p>";
        String newApplicants = "Singh001 - Shahbaz Singh\n".trim();
        ResumeParsingOutputData applicantData = new ResumeParsingOutputData(newApplicants, presentableString);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowApplicantsViewModel showApplicantsViewModel = new ShowApplicantsViewModel();
        ResumeParsingPresenter presenter = new ResumeParsingPresenter(viewManagerModel, showApplicantsViewModel);

        presenter.prepareSuccessView(applicantData);
        ShowApplicantsState showApplicantsState = showApplicantsViewModel.getState();

        assertEquals(showApplicantsState.getApplicantsToDisplay(), presentableString);

    }
}