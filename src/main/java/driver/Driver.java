package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static helper.SauceLab.*;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null) {
            try {
                driver = new RemoteWebDriver(new URL(URL), sauceLabCloudCombination(3));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
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
