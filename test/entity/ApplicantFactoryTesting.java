package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicantFactoryTesting {
    String filepath = "C:\\Users\\sgura\\IdeaProjects\\TalentVista\\test\\entity\\testResume.pdf";
    private ApplicantFactory af = new ApplicantFactory();

    @Test
    void testPassingResponse(){
        try {
            Applicant newApp = af.makeApplicantFromString(filepath, 1, "dev");
            assertEquals("Singh002", newApp.getId());
            assertEquals("Shahbaz Singh", newApp.getName());
            assertEquals("2023-12-01", newApp.getUploadDate());
            assertEquals("{phone=+1 416-985-2000, email=shahbaz.nanda.1@gmail.com}", newApp.getContactInfo().toString());
            assertEquals("[linkedin.com/in/singh-shahbaz]", newApp.personal_urls().toString());
            assertEquals("[3D Modeling, Agility, Algorithms, Application Programming Interface (API), Assembling, Automation, C++ (Programming Language), Call Center Management, Cascading Style Sheet, Competitiveness, Computer Science, Curiosity, Customer Relationship Management, Data Organization, Document Preparation, Document Production, Energetic, Etl Tool, File Transfer Protocol, Fitness Testing, Full Stack Software Engineering, Hypertext Markup Language, Innovation, Interface, JavaScript (Programming Language), Lead Tracking, Learning, Learning Management System, Legal Instrument, Leverage, OLE DB, PHP, Programming Language, Prototyping, Python (Programming Language), Reliability, Robotic Design, Robotics, SWOT Analysis, Sap Implementation, Search Engine Optimization, Simulations, SolidWorks, Streamline, Streamlines, Web Application, Web Scraping, WordPress, ZebraDesigner]", newApp.getSkills().toString());
        } catch (Exception e){
            fail("Exception is not expected");
        }
    }
}
