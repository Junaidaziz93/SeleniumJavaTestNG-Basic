package commonMethods;

import baseTest.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
public  class ActionUtils extends BaseTest {
    public static void takeScreenshot(){

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        String screenShotPath = System.getProperty("user.dir") + "/src/test/Reports/Screenshots/"+actualDate+".jpeg";
        File dest = new File(screenShotPath);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(screenShotPath,"Testcase screenshot");
    }


    public static String getPropertiesValues(String key) throws Exception {
        Properties prop = new Properties();

        // 1. Load data from properties file
        String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";

        // Use try-with-resources to ensure the FileInputStream is closed properly
        try (FileInputStream fis = new FileInputStream(propFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new Exception("Failed to load properties file: " + propFilePath, e);
        }

        // 2. Read values from the file using getProperty() instead of get()
        String value = prop.getProperty(key);

        // 3. Check if value is null or empty
        if (value == null || value.trim().isEmpty()) {
            throw new Exception("Value not available for key '" + key + "' in the properties file.");
        }
        return value;
    }

}
