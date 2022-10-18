package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

import static driver.Clouds.getRemoteDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String machine, String browser) {
        if(machine.equals("local")) {
            driver = getLocalDriver(browser);
        } else if (machine.equals("remote")) {
            driver = getRemoteDriver(System.getProperty("cloud"));
        }
        return driver;
    }

    public static WebDriver getLocalDriver(String browser) {
        Capabilities capabilities = Browsers.getCapabilities(browser);
        switch (browser) {
            case "chrome" :
                WebDriverManager.getInstance(ChromeDriver.class).setup();
                return new ChromeDriver((ChromeOptions) Objects.requireNonNull(capabilities));
            case "firefox" :
                WebDriverManager.getInstance(FirefoxDriver.class).setup();
                return new FirefoxDriver((FirefoxOptions) Objects.requireNonNull(capabilities));
            case "edge" :
                WebDriverManager.getInstance(EdgeDriver.class).setup();
                return new EdgeDriver((EdgeOptions) Objects.requireNonNull(capabilities));
        }
        return null;
    }
}
