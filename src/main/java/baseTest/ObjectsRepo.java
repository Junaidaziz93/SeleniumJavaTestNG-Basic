package baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import pageObjects.EnterVehicleDataObjects;
import pageObjects.HomePageObjects;

public class ObjectsRepo {

    // Declare a static WebDriver instance to be used by all test classes
    public static WebDriver driver;

    // Declare a static instance for HomePageObjects to interact with homepage elements
    public static HomePageObjects homepage;

    // Declare a static instance for EnterVehicleDataObjects to interact with vehicle data page elements
    public static EnterVehicleDataObjects enterVehicleData;

    // Declare a static instance of ExtentSparkReporter for generating reports with SparkReporter
    public static ExtentSparkReporter sparkReport;

    // Declare a static instance of ExtentReports for managing the overall test report
    public static ExtentReports extent;

    // Declare a static instance of ExtentTest for tracking individual test cases in reports
    public static ExtentTest test;
}
