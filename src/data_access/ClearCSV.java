package data_access;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ClearCSV {
    private String filePath;

    ClearCSV(String filePath){
        this.filePath = filePath;
    }

    public void ClearCSVOperation(){
        String csvFilePath = filePath;
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath));
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
