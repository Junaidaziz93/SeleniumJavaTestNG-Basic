package commonMethods;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelUtils {

    // Variable to store the file path of the test data
    String testDataPath;

    // Variable to store the Excel sheet object
    Sheet sh;

    // Constructor to initialize the Excel sheet based on the given sheet name
    public ExcelUtils(String sheetName) {
        try {
            // Set the path to the test data Excel file
            testDataPath = System.getProperty("user.dir") + "/src/test/resources/TestData/testdata.xlsx";
        } catch (Exception e) {
            // Throw a runtime exception if there is an error while setting the path
            throw new RuntimeException(e);
        }

        // Create a File object pointing to the Excel file
        File testDataFile = new File(testDataPath);
        Workbook wb = null;

        try {
            // Open the Excel file and create a Workbook object
            wb = WorkbookFactory.create(testDataFile);
        } catch (IOException e) {
            // Throw a runtime exception if there is an error opening the file
            throw new RuntimeException(e);
        }

        // Get the specified sheet from the workbook
        sh = wb.getSheet(sheetName);
    }

    // Method to retrieve test data from the Excel sheet and return it as a HashMap
    public HashMap<String, String> getTestDataInMap(int rownum) throws IOException {

        // Create a HashMap to store the test data as key-value pairs
        HashMap<String, String> hm = new HashMap<String, String>();

        // Loop through the cells in the first row (header row) to get column names
        for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
            // Set the cell type to String for easy comparison and retrieval
            sh.getRow(rownum).getCell(i).setCellType(CellType.STRING);

            // Add the data to the HashMap where the key is the column name, and the value is the cell value
            hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rownum).getCell(i).toString());
        }

        // Return the populated HashMap containing the row's data
        return hm;
    }

    // Method to get the total number of rows in the sheet (excluding header row)
    public int getRowCount() {
        return sh.getLastRowNum();
    }

    // Method to get the total number of columns in the sheet (based on header row)
    public int getColumnCount() {
        return sh.getRow(0).getLastCellNum();
    }

    // Main method for testing the utility class
    public static void main(String[] args) throws Exception {
        // Create an instance of ExcelUtils for a specific sheet
        ExcelUtils td = new ExcelUtils("Sheet1");

        // Retrieve and print test data from the specified row
        System.out.println("Data is " + td.getTestDataInMap(4));
    }
}
