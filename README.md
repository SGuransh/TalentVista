# TalentVista
HR Management Software

## Problem Domain
Problem Domain: Human Resource Management and Employee Engagement Software

### Description:
Our software is designed to streamline and enhance various aspects of human resource management and employee engagement within an organization. It addresses several critical functions that HR departments typically handle. The software aims to improve efficiency, accuracy, and overall employee satisfaction.

## Detailed UseCases
1. Resume Parsing:
   1. Upload Resumes
   2. Displaying and filtering
   3. Delete Applicant
   4. Delete all filtered Applicants
   5. Approve Applicant
2. Making Employees
3. Login
4. Making Leave Request for the Employee
5. Approving Leave Request for the HR

### Key Features and Problem Areas:

1. Resume Parsing and Scoring for  the hiring process:

Problem: Efficiently parsing incoming resumes and evaluating them based on predefined criteria to identify suitable candidates for job openings, thus making a screening process to remove people who are not eligible. 

2. Employee Database:

Problem: Managing a comprehensive database containing detailed employee information, including personal details, employment history, payroll information, and other relevant data.

3. Satisfaction Surveys and Dashboard:

Problem: Collecting feedback from employees through satisfaction surveys and providing a user-friendly dashboard for HR to analyze survey results and make data-driven decisions to improve workplace satisfaction.

4. Complaints and Incidents Registration:

Problem: Establishing a structured process for employees to register complaints and incidents, ensuring that all concerns are properly documented and addressed. The system would also keep a track of all the ongoing incidents and a record of the solved cases.

5. Task and Case Management:

Problem: Efficiently tracking pending  tasks, and assignments within the HR department, and providing tools for creating new tasks and managing their progress.

6. Leave Conflicts Management:

Problem: Effectively managing employee leave requests, ensuring that there are no conflicts or overlaps, and minimizing disruptions to the workflow.

7. Meetings and Appointments:

Problem: Keeping track of upcoming meetings, appointments, and deadlines, and optionally automating email notifications to remind relevant parties.

8. Employee Onboarding:
Problem: Simplifying the process of adding new members or employees to the organization, including creating and delivering automated offer letters.

By addressing these problem areas, our software aims to optimize HR operations, enhance employee satisfaction, and streamline the management of various HR-related tasks and processes. This comprehensive HR and employee engagement solution will contribute to a more efficient and productive workforce, ultimately benefiting the organization as a whole.


## Link to the API Documentation
https://www.superparser.com/documentation

## Screenshot of using the API through Hoppsotch.io
<img width="893" alt="image" src="https://github.com/SGuransh/TalentVista/assets/91618250/fc9eebf7-6b3e-4b76-a961-a2f0c0c2d13c">

## Screenshot of the Output when we run the Java code with the API
<img width="987" alt="image" src="https://github.com/SGuransh/TalentVista/assets/91618250/fa9fb2b2-d642-4590-a3a5-36693ceebd68">

## List of any technical problems blocking progress
We had issues when calling the API directly from our Java machine and code as the API was not properly taking our pdf file for resumes. Through research and troubleshooting, we managed to get it to read a PDF resume, but are worried this will be an issue in the future when reading files and uploading different formats of resumes. Reading the resume was complex code, and we may have issues when integrating the API calling code with our whole project. So we might have to change the API that we are calling in the future.



