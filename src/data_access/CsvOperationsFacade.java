package data_access;

public class CsvOperationsFacade {

    private final ReadCsvBoundary readCsvToInMemory;
    private final SaveToCsvBoundary saveToCsv;
    private final ClearCsvBoundary clearCSV;

    public CsvOperationsFacade(ReadCsvBoundary readCsvToInMemory, SaveToCsvBoundary saveToCsv, ClearCsvBoundary clearCSV) {
        this.readCsvToInMemory = readCsvToInMemory;
        this.saveToCsv = saveToCsv;
        this.clearCSV = clearCSV;
    }

    void ReadCsvOperation(){
        readCsvToInMemory.ReadCsvToInMemoryOperation();
    }

    void saveToCsvOperation(){saveToCsv.SaveToCsvOperation();}

    void clearCsvOperation(){
        clearCSV.ClearCSVOperation();
    }


}
