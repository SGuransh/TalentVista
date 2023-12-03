package data_access;

public class CsvOperationsFacade {

    private final ReadCsvToInMemory readCsvToInMemory;
    private final SaveToCsv saveToCsv;
    private final ClearCSV clearCSV;

    public CsvOperationsFacade(ReadCsvToInMemory readCsvToInMemory, SaveToCsv saveToCsv, ClearCSV clearCSV) {
        this.readCsvToInMemory = readCsvToInMemory;
        this.saveToCsv = saveToCsv;
        this.clearCSV = clearCSV;
    }

    void ReadCsvOperation(){
        readCsvToInMemory.ReadCsvToInMemoryOperation();
    }

    void saveToCsvOperation(){
        saveToCsv.SaveToCsvOperation();
    }

    void clearCsvOperation(){
        clearCSV.ClearCSVOperation();
    }


}
