package commonMethods;

import baseTest.ObjectsRepo;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListeners extends ObjectsRepo implements ITestListener {

    // This method is invoked when the test starts
    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the Extent report for the test that is starting
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // This method is invoked when the test passes successfully
    @Override
    public void onTestSuccess(ITestResult result) {
        // Log the test status as passed in the Extent report
        test.log(Status.PASS, "Testcase" + "  -   " + result.getMethod().getMethodName() + "    " + "is Passed");
        // Take a screenshot and attach it to the report for the successful test
        ActionUtils.takeScreenshot();
    }

    // This method is invoked when the test fails
    @Override
    public void onTestFailure(ITestResult result) {
        // Log the test status as failed in the Extent report
        test.log(Status.FAIL, "Testcase" + "   -  " + result.getMethod().getMethodName() + "    " + "is Failed");
        // Log the exception or error that caused the failure
        test.log(Status.FAIL, result.getThrowable());
        // Take a screenshot and attach it to the report for the failed test
        ActionUtils.takeScreenshot();
    }

    // This method is invoked when the test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        // No specific action is performed here for skipped tests
    }

    // This method is invoked if a test fails but is within the success percentage set in the configuration
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No specific action is performed here for tests within success percentage
    }

    // This method is invoked if a test fails due to a timeout
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // No specific action is performed here for tests failing with a timeout
    }

    // This method is invoked before any tests in the test suite start
    @Override
    public void onStart(ITestContext context) {
        // Initialize the Extent report setup when the test context starts
        extent = ExtentSetup.setupExtentReport();
    }

    // This method is invoked after all the tests in the test suite finish
    @Override
    public void onFinish(ITestContext context) {
        // Finalize and write all information to the Extent report
        extent.flush();
    }
}
