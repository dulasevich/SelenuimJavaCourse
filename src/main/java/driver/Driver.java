package driver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;
    private static final String BROWSER = StringUtils.defaultString(System.getProperty("browser"), "chrome");
    private static final String MACHINE = StringUtils.defaultString(System.getProperty("machine"), "local");

    public static WebDriver getDriver() {
            if (driver == null) {
                driver = DriverFactory.getDriver(MACHINE, BROWSER);
            }
        return driver;
    }

    public static void turnDriverDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
