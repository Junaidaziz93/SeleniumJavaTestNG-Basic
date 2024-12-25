package pageObjects;

import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class EnterVehicleDataObjects extends BaseTest {

    // Constructor to initialize web elements using PageFactory
    public EnterVehicleDataObjects() {
        // Initialize all the elements declared with @FindBy annotations for this class
        PageFactory.initElements(driver, this);
    }

    // Locate the web element for the engine performance input field using its ID
    @FindBy(id = "engineperformance")
    WebElement enginePerformance;

    // Method to enter engine performance data
    public void enterEnginPerformance(HashMap<String, String> testData) throws InterruptedException {
        // Retrieve the value for 'testdata3' from the HashMap and send it to the enginePerformance field
        enginePerformance.sendKeys(testData.get("testdata3"));

        // Add a delay to simulate waiting for user input (or for UI interaction)
        Thread.sleep(3000);

        // Print a message indicating that engine performance data has been entered
        System.out.println("Performance Added");
    }
}
