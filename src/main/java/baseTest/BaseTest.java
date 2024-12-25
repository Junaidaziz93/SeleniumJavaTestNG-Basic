package baseTest;

import commonMethods.ActionUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.EnterVehicleDataObjects;
import pageObjects.HomePageObjects;
import java.util.concurrent.TimeUnit;

public class BaseTest extends ObjectsRepo{

    // Method to launch the browser and navigate to the specified URL
    public void LaunchBrowserAndNavigate() throws Exception {
        // Read properties file and get the browser type and URL
        String browser = ActionUtils.getPropertiesValues("browser");
        String url = ActionUtils.getPropertiesValues("url");

        // Check if the browser is Chrome and set up ChromeDriver
        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup(); // Setup Chrome WebDriver
            driver = new ChromeDriver();  // Initialize ChromeDriver
        }
        else {
            // If not Chrome, set up FirefoxDriver
            WebDriverManager.firefoxdriver().setup(); // Setup Firefox WebDriver
            driver = new FirefoxDriver();  // Initialize FirefoxDriver
        }

        // Set implicit wait timeout for finding web elements
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to the URL specified in the properties file
        driver.get(url);
    }

    // Method to login into the application using provided credentials
    public void loginIntoApplication() throws Exception {
        // Fetch login credentials (username and password) from the properties file
        String username = ActionUtils.getPropertiesValues("username");
        String password = ActionUtils.getPropertiesValues("password");

        // Add a delay to simulate waiting for the login page to load
        Thread.sleep(5000);
        // Find the username input field and enter the username
        driver.findElement(By.name("username")).sendKeys(username);

        // Add a delay to simulate user entering credentials
        Thread.sleep(3000);
        // Find the password input field and enter the password
        driver.findElement(By.name("password")).sendKeys(password);

        // Add another delay to simulate user entering credentials
        Thread.sleep(3000);
        // Find the submit button (login button) and click it to log in
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // Log a message indicating the login button has been clicked
        System.out.println("Login Clicked");

        // Add another delay to simulate waiting for the login action to complete
        Thread.sleep(3000);
    }

    // Method that runs before each test method to set up the browser and objects
    @BeforeMethod
    public void setup() throws Exception {
        // Log a message indicating that the setup is running
        System.out.println("Before Method is Running");
        // Call method to launch browser and navigate to the URL
        LaunchBrowserAndNavigate();
        // Initialize page object models
        homepage = new HomePageObjects();
        enterVehicleData = new EnterVehicleDataObjects();
        // Optionally call the login method to log in to the application
        // loginIntoApplication();
    }

    // Method that runs after each test method to clean up
    @AfterMethod
    public void tearDown() throws InterruptedException {
        // Add a delay before quitting the browser
        Thread.sleep(3000);
        // Close the browser and clean up the WebDriver instance
        driver.quit();
        // Log a message indicating the after-method is executed
        System.out.println("After Method is Executed");
    }
}
