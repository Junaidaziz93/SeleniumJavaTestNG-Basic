package commonMethods;

import baseTest.ObjectsRepo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentSetup extends ObjectsRepo {

    // Method to set up the Extent report with configuration and file path
    public static ExtentReports setupExtentReport() {

        // Format the current date and time for report file naming
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        // Define the path for the HTML report using the formatted date and time
        String reportPath = System.getProperty("user.dir") + "/src/test/Reports/ExecutionReport_" + actualDate + ".html";

        // Initialize the ExtentSparkReporter to create the HTML report at the specified path
        sparkReport = new ExtentSparkReporter(reportPath);

        // Create an instance of ExtentReports to manage the report
        ExtentReports extent = new ExtentReports();

        // Attach the Spark reporter to the ExtentReports object
        extent.attachReporter(sparkReport);

        // Set the theme of the report (e.g., Standard theme)
        sparkReport.config().setTheme(Theme.STANDARD);

        // Set the document title of the report
        sparkReport.config().setDocumentTitle("Execution Report");

        // Set the name of the report
        sparkReport.config().setReportName("Execution Report");

        // Return the configured ExtentReports instance
        return extent;
    }
}
