package nicebank;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;

public class WebdriverHooks {

    @Autowired
    SharedDriver sharedDriver;

    @After
    public void finish(Scenario scenario){
        try{
            byte[] screensshot =
                    sharedDriver.getScreenshotAs(OutputType.BYTES);
        }catch (WebDriverException somePlatformsDoNotSupportScreenShots) {
            System.err.println(somePlatformsDoNotSupportScreenShots.getMessage());
        }
        finally {
            sharedDriver.close();
        }
    }

}
