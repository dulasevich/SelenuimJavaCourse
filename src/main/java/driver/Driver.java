package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            driver = new ChromeDriver();
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
