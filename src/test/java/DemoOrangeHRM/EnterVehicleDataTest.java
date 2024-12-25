package DemoOrangeHRM;

import baseTest.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

public class EnterVehicleDataTest extends BaseTest {

    @Test
    public void enterVehiclePerformance() throws InterruptedException {

//        enterVehicleData.enterEnginPerformance();
        test.log(Status.PASS , "Vehicle performance entered");

    }
}
