package DemoOrangeHRM;

import com.aventstack.extentreports.Status;
import commonMethods.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseTest.BaseTest;

import java.io.IOException;
import java.util.HashMap;

public class HomePageTest extends BaseTest {

    // Initialize ExcelUtils with the sheet name "Sheet1" to read test data
    ExcelUtils excelUtils = new ExcelUtils("Sheet1");

    // Test to verify if the Automobile tab is displayed (currently disabled)
    @Test(priority = 1, enabled = false)
    public void verifyAutomobileTab() throws Exception {
        // Call the method to verify the Automobile tab
        homepage.verifyAutomobileTab();

        // Log the result in the Extent report as PASS
        test.log(Status.PASS, "Automobile Tab is displayed & Verified");
    }

    // Test to click the Automobile tab and enter engine performance data (enabled and using data provider)
    @Test(dataProvider = "vehDataProvider", priority = 2, enabled = true)
    public void clickOnAutomobileTab(Object obj1) throws Exception {
        // Convert the data provider object into a HashMap containing test data
        HashMap<String, String> testData = (HashMap<String, String>) obj1;
        System.out.println("Test data is " + testData);

        // Click on the Automobile tab
        homepage.clickOnAutomobileTab();

        // Enter engine performance data using test data from Excel
        enterVehicleData.enterEnginPerformance(testData);

        // Log the result in the Extent report as PASS
        test.log(Status.PASS, "Automobile Tab is clicked");
    }

    // Test to verify the Admin tab (currently disabled)
    @Test(priority = 1, enabled = false)
    public void verifyAdminTab() throws Exception {
        // Click on the Admin tab
        homepage.clickOnAdmin();

        // Verify if the Admin title is displayed
        homepage.verifyAdminTab();
    }

    // Test to verify the PIM tab (currently disabled)
    @Test(priority = 2, enabled = false)
    public void verifyPimTab() throws Exception {
        // Click on the PIM tab
        homepage.clickOnPim();

        // Verify if the PIM title is displayed
        homepage.verifyPimTab();
    }

    // Test to verify the Leave tab (currently disabled)
    @Test(priority = 3, enabled = false)
    public void verifyLeaveTab() throws Exception {
        // Click on the Leave tab
        homepage.clickOnLeave();

        // Verify if the Leave title is displayed
        homepage.verifyLeaveTab();
    }

    // Data provider method to supply test data from the Excel sheet for multiple test iterations
    @DataProvider(name = "vehDataProvider")
    public Object[][] testDataProvider() throws IOException {
        // Get the total number of rows in the Excel sheet
        int totalRows = excelUtils.getRowCount();

        // Initialize a 2D array to store the test data for each row
        Object[][] obj = new Object[totalRows - 1][1];

        // Loop through each row starting from the second row (skipping the header)
        for (int i = 1; i < excelUtils.getRowCount(); i++) {
            // Retrieve the test data as a HashMap for each row
            HashMap<String, String> testData = excelUtils.getTestDataInMap(i);

            // Store the test data in the array
            obj[i - 1][0] = testData;
        }

        // Return the 2D array containing the test data for the data provider
        return obj;
    }
}
