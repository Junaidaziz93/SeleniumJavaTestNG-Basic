package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import baseTest.BaseTest;

public class HomePageObjects extends BaseTest {

    // Constructor to initialize the elements on the homepage using PageFactory
    public HomePageObjects() {
        // Initialize all the elements declared with @FindBy annotations for this class
        PageFactory.initElements(driver, this);
    }

    // Web element for the Admin tab, located by its text
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin;

    // Web element for the Admin title, located by its text
    @FindBy(xpath = "//h6[text()='Admin']")
    WebElement adminTittle;

    // Web element for the PIM tab, located by its text
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pim;

    // Web element for the PIM title, located by its text
    @FindBy(xpath = "//h6[text()='PIM']")
    WebElement pimTittle;

    // Web element for the Leave tab, located by its text
    @FindBy(xpath = "//span[text()='Leave']")
    WebElement leave;

    // Web element for the Leave title, located by its text
    @FindBy(xpath = "//h6[text()='Leave']")
    WebElement leaveTittle;

    // Web element for the Automobile tab, located by its name attribute
    @FindBy(name = "Navigation Automobile")
    WebElement automobile;

    // Method to click the Admin tab
    public void clickOnAdmin() {
        admin.click();
        System.out.println("Admin Tab Clicked");
    }

    // Method to verify if the Admin title is displayed
    public void verifyAdminTab() {
        Assert.assertTrue(adminTittle.isDisplayed(), "Admin Title is not displayed.");
        System.out.println("Admin Tab is displayed");
        System.out.println("Admin Tab Verified");
    }

    // Method to click the PIM tab
    public void clickOnPim() {
        pim.click();
        System.out.println("PIM Tab Clicked");
    }

    // Method to verify if the PIM title is displayed
    public void verifyPimTab() {
        Assert.assertTrue(pimTittle.isDisplayed(), "PIM Title is not displayed.");
        System.out.println("PIM Tab is displayed");
        System.out.println("PIM Tab Verified");
    }

    // Method to click the Leave tab
    public void clickOnLeave() {
        leave.click();
        System.out.println("Leave Tab Clicked");
    }

    // Method to verify if the Leave title is displayed
    public void verifyLeaveTab() {
        Assert.assertTrue(leaveTittle.isDisplayed(), "Leave Title is not displayed.");
        System.out.println("Leave Tab is displayed");
    }

    // Method to verify if the Automobile tab is displayed
    public void verifyAutomobileTab() {
        Assert.assertTrue(automobile.isDisplayed(), "Automobile Tab is not displayed.");
        System.out.println("Automobile Tab is Displayed");
        System.out.println("Automobile Tab is Verified");
    }

    // Method to click the Automobile tab
    public void clickOnAutomobileTab() {
        automobile.click();
        System.out.println("Automobile Tab is clicked");
    }
}
