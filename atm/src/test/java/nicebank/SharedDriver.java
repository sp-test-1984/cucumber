package nicebank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.stereotype.Component;

@Component
public class SharedDriver extends EventFiringWebDriver {

    private EventFiringWebDriver webDriver;

    public SharedDriver(WebDriver driver) {
        super(driver);
    }

    public EventFiringWebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }
        return webDriver;
    }
}
