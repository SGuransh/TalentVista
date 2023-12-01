package use_case.HireApplicantButton;

import entity.Employee;
import entity.EmployeeFactory;

import java.time.LocalDateTime;

public class HireApplicantInteractor implements HireApplicantInputBoundary{
    final HireApplicantDataAccessInterface employeeDataAccessObject;
    final AutoMailSend mailSender;
    final HireApplicantOutputBoundary hireApplicantPresenter;

    public HireApplicantInteractor(HireApplicantDataAccessInterface employeeDataAccessObject, AutoMailSend mailSender, HireApplicantOutputBoundary hireApplicantPresenter) {
        this.employeeDataAccessObject = employeeDataAccessObject;
        this.mailSender = mailSender;
        this.hireApplicantPresenter = hireApplicantPresenter;
    }

    @Override
    public void execute(HireApplicantInputData inputData) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.create(inputData.getName(), "password", LocalDateTime.now(), inputData.getSalary(), inputData.getPosition(), inputData.getEmail());
        employeeDataAccessObject.addEmployee(employee);
        sendEmail(employee);
        HireApplicantOutputData outputData = new HireApplicantOutputData(employeeDataAccessObject.getEmployeeData(employee));
        hireApplicantPresenter.prepareSuccessView(outputData);
    }
    private void sendEmail(Employee employee) {
        // Customize email content based on employee details
        String mailTo = employee.getEmail();  // Set your recipient email address
        String subject = "New Employee Hired";
        String text = "Dear " + employee.getName() + ",\n\n"
                + "Congratulations! You have been hired as a new employee at our company.";

        // Update the recipient email and other details as needed
        mailSender.setRecipient(mailTo);
        mailSender.setSubject(subject);
        mailSender.setText(text);

        // Send the email
        mailSender.send();
    }
}
