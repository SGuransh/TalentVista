package use_case.HireApplicantButton;

import entity.Employee;

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
        employeeDataAccessObject.addEmployee(inputData.getEmployee());
        sendEmail(inputData.getEmployee());
        HireApplicantOutputData outputData = new HireApplicantOutputData(employeeDataAccessObject.getEmployeeData(inputData.getEmployee()));
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
