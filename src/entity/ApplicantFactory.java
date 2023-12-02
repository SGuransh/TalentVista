package entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class ApplicantFactory {

    public String stringFromFile(String fileLocation, Integer id) throws MalformedURLException, IOException {
        try {
//            String apiKey = "JrtEnkroQW3FIvGTkp1JU139SDLuuITr0hYGIAi8";
//            String apiKey = "Pyo690Facd5t2QZfxKz3N2e6HYpYbxDLaNX8213x";
            String apiKey = "OgC9YbOTCj5CY9S9JEOwNmJDH4ixvUD2zhXcQiEj";
            File fileToUpload;

            // Define the file to be uploaded
            // File fileToUpload = new File("C:\\Users\\sgura\\OneDrive\\Pictures\\Documents\\Downloads\\Resume.pdf");
            if (fileLocation == null) {
                fileToUpload = new File("C:\\Users\\sgura\\OneDrive\\Pictures\\Documents\\Downloads\\Resume of Ayush Aran (Internship).pdf");
            } else {
                fileToUpload = new File(fileLocation);
            }
            // Generate a random boundary string
            String boundary = "----" + System.currentTimeMillis();

            // Create a URL object for the API endpoint
            URL url = new URL("https://api.superparser.com/parse");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the HTTP request method to POST
            connection.setRequestMethod("POST");

            // Enable input/output streams and set other headers
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            connection.setRequestProperty("X-API-Key", apiKey);

            try (OutputStream os = connection.getOutputStream()) {
                // Start the multipart/form-data request
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);

                // Add the file part
                writer.append("--" + boundary).append("\r\n");
                writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileToUpload.getName() + "\"\r\n");
                writer.append("Content-Type: application/pdf\r\n");
                writer.append("\r\n");
                writer.flush();

                // Write the file contents
                try (FileInputStream fis = new FileInputStream(fileToUpload)) {
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    os.flush();
                }

                // End the multipart/form-data request
                writer.append("\r\n--").append(boundary).append("--\r\n");
                writer.flush();
            }

            // Get the HTTP response code
            int responseCode = connection.getResponseCode();

            // Read and handle the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    // System.out.println(response.toString());
                    // Close the connection
                    connection.disconnect();
                    return response.toString();
                }
            } else {
                System.err.println("HTTP Request Failed with status code: " + responseCode);
                // Close the connection
                connection.disconnect();
                return "HTTP Request Failed with status code: " + responseCode;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        }
    }

    public Applicant makeApplicantFromString(String fileLocation, Integer id, String position) throws MalformedURLException, IOException, JSONException {
//        String position = "dev";
        String str = stringFromFile(fileLocation, id);
        // String str = "{\"status\": \"success\", \"data\": {\"name\": {\"full_name\": \"Guransh Singh\", \"first_name\": \"Guransh\", \"last_name\": \"Singh\"}, \"email\": [{\"email\": \"sguransh24@gmail.com\"}], \"employer\": [{\"company_name\": \"Cgi Canada\", \"role\": \"Software Developer Intern\", \"from_year\": 2020, \"from_month\": 5, \"to_year\": 2020, \"to_month\": 9, \"description\": \"Toronto, Ontario\\n\\u2022 Developed Python programs to work with the large amounts of data that were to be analyzed by the Performance testing\\nteam, thus helping in swift analysis.\\nPreparing a Master sheet for the ids used by the PTE team, analysing the ids used for the Non functional testing in the\\n\\u2022\\nscripts. Making the manual testing and introduction of new people easier.\\n\\u2022 Worked with the team to gather and present evidences for the audit for that fiscal year.\\nUsed the internal tools and Jira for Project management tasks and making work orders, incident tickets and change\\n\\u2022\\nrequests. Made task list for the morning scrum meetings.\\nUOFT AI\\nSeptember 2022 \\u2013 Feburary 2023\\nTeam Member\\nToronto, Ontario\\n\\u2022 Got Proficiency in using the libraries like sklearn, pandas, matplotlib, plotly, numpy and tensorflow learnt to use them in\\nvarious problems.\\nCompleted the comprehensive curriculum of weekly lectures and coding activities, leading to improvement in the\\n\\u2022\\nconcepts of machine learning.\\n\\u2022 Actively engaged in group discussions and the weekly workshops they have to offer and dedicated 10 hours weekly for the\\nclub.\", \"skills\": [\"Python (Programming Language)\", \"Performance Testing\", \"Swift (Programming Language)\", \"Analysis\", \"Intrusion Detection System\", \"Analysis\", \"Intrusion Detection System\", \"Non functional Testing\", \"Manual Testing\", \"Auditing\", \"JIRA\", \"Project Management\", \"Scrum (Software Development)\", \"Artificial Intelligence\", \"pandas\", \"Matplotlib\", \"Plotly Software\", \"NumPy\", \"TensorFlow\", \"Comprehensive\", \"Lecturing\", \"Programming Language\", \"Machine Learning\", \"Group Discussion\", \"Dedication\"]}], \"total_experience\": {\"months\": 5}, \"education\": [{\"institute\": \"University Of Toronto\", \"degree\": \"Bachelor Of Science\", \"course\": \"Computer Science\", \"to_year\": 2020, \"to_month\": 9}], \"phone\": [{\"phone\": \"3657 375 055\"}], \"others_heading\": \"Projects\\nFlickFindr | Python, APIs, Pandas\\n\\u2022 Developed an application to recommend movies based on an algorithm built on trees which takes into account the people\\nwho rated the movie weighted by the similarity between the person and them.\\nImplemented a python framework called pygame to make the UI for the application and the backend is based on python\\n\\u2022\\nThe application utilizes APIs to fetch additional information about the recommendations after they are identified. This\\n\\u2022\\nincludes the platform links to watch the movie on, the poster, the IMDB rating.\\n\\u2022 Uses a pre-cleaned database with pandas and numpy, for the information about the movies and the datapoints of the\\npeople who rated the movies.\\nImpossible TicTacToe | Kotlin, Android Studio\\n\\u2022 Created an Android application using Kotlin and Android Studio to make a playable TicTacToe for android with\\ndifferent levels of difficulty.\\nThe program uses minmax algorithm to make the best move when playing on the hard mode.\\n\\u2022\", \"skills_heading\": \"Technical Skills and Soft Skills\\nLanguages: Python, Java, C++, R, Bash, Kotlin, Javascript, SQL\\nDeveloper Tools: VS Code, Intellij, Oracle Virtual Box, Google Colab\\nTechnologies/Frameworks: Linux, GitHub, BitBucket, Jira BBD\\nLanguages Spoken : English, Hindi, Punjabi\\nLeadership / Extracurricular\\nUnited Sikhs Volunteer\\n2020 \\u2013 2022\\nGeneral Member\\n\\u2217 Have been an active member throughout the covid period, helping in distributing cooked meals and distributing groceries\\n\\u2217 Helped in organizing a number of fund raising events throughout that period.\\n\\u2217 Led small teams for the different projects we had for humanitarian aid.\", \"personal_details_top_heading\": \"Guransh Singh\\nToronto, Ontario\\n\\ufffd 365-737-5055 \\ufffd sguransh24@gmail.com \\ufffd linkedin.com/in/guransh-singh \\ufffd github.com/SGuransh\", \"address\": {\"city\": \"toronto\", \"country_code\": \"CA\", \"_source\": \"personal_details_top\"}, \"projects\": [{\"description\": \"Projects\\nFlickFindr | Python, APIs, Pandas\\n\\u2022 Developed an application to recommend movies based on an algorithm built on trees which takes into account the people\\nwho rated the movie weighted by the similarity between the person and them.\\nImplemented a python framework called pygame to make the UI for the application and the backend is based on python\\n\\u2022\\nThe application utilizes APIs to fetch additional information about the recommendations after they are identified. This\\n\\u2022\\nincludes the platform links to watch the movie on, the poster, the IMDB rating.\\n\\u2022 Uses a pre-cleaned database with pandas and numpy, for the information about the movies and the datapoints of the\\npeople who rated the movies.\\nImpossible TicTacToe | Kotlin, Android Studio\\n\\u2022 Created an Android application using Kotlin and Android Studio to make a playable TicTacToe for android with\\ndifferent levels of difficulty.\\nThe program uses minmax algorithm to make the best move when playing on the hard mode.\\n\\u2022\", \"skills\": [\"Python (Programming Language)\", \"Application Programming Interface (API)\", \"pandas\", \"Algorithms\", \"Python (Programming Language)\", \"Software Framework\", \"Pygame\", \"User Interface\", \"Back End\", \"Python (Programming Language)\", \"Application Programming Interface (API)\", \"OLE DB\", \"pandas\", \"NumPy\", \"Kotlin Programming Language\", \"Android Studio\", \"Android Application\", \"Kotlin Programming Language\", \"Android Studio\", \"Android\", \"Minmax\", \"Algorithms\"]}], \"personal_urls\": [\"linkedin.com/in/guransh-singh\", \"github.com/sguransh\"], \"total_time\": 2.165170192718506, \"skills\": {\"skills_meta\": [{\"display_name\": \"Manual Testing\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Scrum (Software Development)\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Swift (Programming Language)\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Artificial Intelligence\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Dedication\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Machine Learning\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"pandas\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"JIRA\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Project Management\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Plotly Software\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Performance Testing\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"NumPy\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Matplotlib\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Group Discussion\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Intrusion Detection System\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Auditing\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Programming Language\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Lecturing\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"TensorFlow\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Non functional Testing\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Comprehensive\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Python (Programming Language)\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}, {\"display_name\": \"Analysis\", \"experience\": 42.93, \"last_used_on\": \"2023-11-10T00:00:00\", \"timeline\": [{\"from_date\": \"2020-05-01T00:00:00\", \"to_date\": \"2023-11-10T00:00:00\", \"source\": [\"employer_description_skills\"]}]}], \"overall_skills\": [\"Algorithms\", \"Analysis\", \"Android\", \"Android Application\", \"Android Studio\", \"Application Programming Interface (API)\", \"Artificial Intelligence\", \"Auditing\", \"Back End\", \"Comprehensive\", \"Dedication\", \"Group Discussion\", \"Intrusion Detection System\", \"JIRA\", \"Kotlin Programming Language\", \"Lecturing\", \"Machine Learning\", \"Manual Testing\", \"Matplotlib\", \"Minmax\", \"Non functional Testing\", \"NumPy\", \"OLE DB\", \"Performance Testing\", \"Plotly Software\", \"Programming Language\", \"Project Management\", \"Pygame\", \"Python (Programming Language)\", \"Scrum (Software Development)\", \"Software Framework\", \"Swift (Programming Language)\", \"TensorFlow\", \"User Interface\", \"pandas\"]}}, \"total_time\": 2.1809396743774414}";
        JSONObject obj = new JSONObject(str);
        JSONObject data = new JSONObject(obj.get("data").toString());   // response.data
        String name = "N/A";
        String last_name = "N/A";
        HashMap<String, String> contactInfo = new HashMap<>();
        ArrayList<String> urls = new ArrayList<String>();
        ArrayList<String> skills = new ArrayList<String>();
        try {
            name = new JSONObject(data.get("name").toString()).getString("full_name");   // response.data.name.full_name
        } catch (JSONException e) {
            name = "Not Found";
            System.out.println("JSONError in reading name");
        }
        try {
            last_name = new JSONObject(data.get("name").toString()).getString("last_name");   // response.data.name.last_name
        } catch (JSONException last_name_e) {
            last_name = "Not Found";
            System.out.println("JSONError in reading last name");
        }
        String uploadDate = LocalDateTime.now().toLocalDate().toString();
        // Making the Hashmap
        try {
            contactInfo = new HashMap<>();
            String email = data.get("email").toString();
            email = email.replace("]", "");
            email = email.replace("[", "");
            email = email.replace("\"", "");
            email = email.replace("{", "");
            email = email.replace("}", "");
            email = email.replace("email:", "");
            String phone = data.get("phone").toString();
            phone = phone.replace("]", "");
            phone = phone.replace("[", "");
            phone = phone.replace("\"", "");
            phone = phone.replace("{", "");
            phone = phone.replace("}", "");
            phone = phone.replace("phone:", "");
            contactInfo.put("email", email);
            contactInfo.put("phone", phone);
//            contactInfo.put("address", new JSONObject(data.get("address").toString()).getString("city") + "-" + new JSONObject(data.get("address").toString()).getString("country_code"));
        } catch (JSONException contact_info_e) {
            contactInfo = new HashMap<>();
            System.out.println("JSONError in reading contact info");
        }
        try {
            String personal_urls = data.getString("personal_urls");
            urls = new ArrayList<String>();
            personal_urls = personal_urls.replace("]", "");
            personal_urls = personal_urls.replace("[", "");
            personal_urls = personal_urls.replace("\"", "");
            String[] elements = personal_urls.split(",");
            for (String element : elements) {
                element.replace(" ", "");
                urls.add(element);
            }
        } catch (JSONException personal_urls_e) {
            urls = new ArrayList<String>();
            System.out.println("JSONError in reading personal urls");
        }
        try {
            skills = new ArrayList<String>();
            JSONArray overallSkills = new JSONObject(data.get("skills").toString()).getJSONArray("overall_skills");
            for (int i = 0; i < overallSkills.length(); i++) {
                skills.add(overallSkills.getString(i));
            }
        } catch (JSONException skills_e) {
            skills = new ArrayList<String>();
            System.out.println("JSONError in reading skills");
        }
        String idString = last_name + "00" + (id + 1);
        return create(idString, name, skills, uploadDate, contactInfo, urls, position);
    }

    public Applicant create(String id, String name, ArrayList<String> skills, String uploadDate, HashMap<String, String> contactInfo, ArrayList<String> personal_urls, String position) {
        return new Applicant(id, name, skills, uploadDate, contactInfo, personal_urls, position);
    }

//    public static void main(String[] args) {
//        ApplicantFactory af = new ApplicantFactory();
//        try {
////            Applicant a = af.makeApplicantFromString("C:\\Users\\sgura\\OneDrive\\Pictures\\Documents\\Downloads\\Resume.pdf", 1, "dev");
////            Applicant a = af.makeApplicantFromString("C:\\Users\\sgura\\OneDrive\\Pictures\\Documents\\Downloads\\resumes\\Resume of Ayush Aran (Internship).pdf", 1, "dev");
//            Applicant a = af.makeApplicantFromString("C:\\Users\\sgura\\OneDrive\\Pictures\\Documents\\Downloads\\resumes\\_Shahbaz_Singh_Resume_2023.pdf", 1, "dev");
//            System.out.println(a.getId());
//            System.out.println(a.getName());
//            System.out.println(a.getSkills());
//            System.out.println(a.getUploadDate());
//            System.out.println(a.getContactInfo());
//            System.out.println(a.personal_urls());
//            System.out.println(a.getUploadDate());
//        } catch (Exception e) {
//            System.out.println("caught in line 164");
//            System.out.println(e);
//        }
//    }
}