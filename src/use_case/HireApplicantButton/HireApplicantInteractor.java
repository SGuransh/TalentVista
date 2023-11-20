package use_case.HireApplicantButton;

import entity.Employee;

public class HireApplicantInteractor implements HireApplicantInputBoundary{
    final HireApplicantDataAccessInterface EmployeeDataAccessObject;
    final AutoMailSend mailSender;

    public HireApplicantInteractor(HireApplicantDataAccessInterface employeeDataAccessObject, AutoMailSend mailSender) {
        EmployeeDataAccessObject = employeeDataAccessObject;
        this.mailSender = mailSender;
    }

    @Override
    public void execute(HireApplicantInputData inputData) {
        EmployeeDataAccessObject.addEmployee(inputData.getEmployee());
        sendEmail(inputData.getEmployee());
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
