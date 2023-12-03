//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class API_Call {
//    public static void main(String[] args) throws Exception {
//        // Replace "SIGN-UP-FOR-KEY" with your actual RapidAPI key
//        String apiKey = "JrtEnkroQW3FIvGTkp1JU139SDLuuITr0hYGIAi8";
//
//        // Define the file to be uploaded
//        File fileToUpload = new File("C:\\Users\\sgura\\OneDrive\\Pictures\\Documents\\Downloads\\Resume.pdf");
////        File fileToUpload = new File("C:\\Users\\sgura\\OneDrive\\Pictures\\Documents\\Downloads\\Resume of Ayush Aran (Internship).pdf");
//
//        // Generate a random boundary string
//        String boundary = "----" + System.currentTimeMillis();
//
//        // Create a URL object for the API endpoint
//        URL url = new URL("https://api.superparser.com/parse");
//
//        // Open a connection to the URL
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        // Set the HTTP request method to POST
//        connection.setRequestMethod("POST");
//
//        // Enable input/output streams and set other headers
//        connection.setDoOutput(true);
//        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
//        connection.setRequestProperty("X-API-Key", apiKey);
//
//        try (OutputStream os = connection.getOutputStream()) {
//            // Start the multipart/form-data request
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
//
//            // Add the file part
//            writer.append("--" + boundary).append("\r\n");
//            writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileToUpload.getName() + "\"\r\n");
//            writer.append("Content-Type: application/pdf\r\n");
//            writer.append("\r\n");
//            writer.flush();
//
//            // Write the file contents
//            try (FileInputStream fis = new FileInputStream(fileToUpload)) {
//                byte[] buffer = new byte[8192];
//                int bytesRead;
//                while ((bytesRead = fis.read(buffer)) != -1) {
//                    os.write(buffer, 0, bytesRead);
//                }
//                os.flush();
//            }
//
//            // End the multipart/form-data request
//            writer.append("\r\n--" + boundary + "--\r\n");
//            writer.flush();
//        }
//
//        // Get the HTTP response code
//        int responseCode = connection.getResponseCode();
//
//        // Read and handle the response
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//                String line;
//                StringBuilder response = new StringBuilder();
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//            }
//        } else {
//            System.err.println("HTTP Request Failed with status code: " + responseCode);
//        }
//
//        // Close the connection
//        connection.disconnect();
//    }
//}