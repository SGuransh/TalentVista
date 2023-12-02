package data_access;

import entity.Employee;
import entity.User;
import use_case.login.LoginUserDataAccessInterface;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements LoginUserDataAccessInterface {

    private final Map<String, String> users = new HashMap<>();
    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public User get(String username) {
        return null;
    }

    public void ReadCsvToInMemory(){
        String csvFile = "src/data_access/defaultUser.csv";
        String line;
        String csvSplitBy = ","; // CSV files typically use commas as separators
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                users.put(data[0], data[1]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

