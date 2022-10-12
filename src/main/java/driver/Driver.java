package driver;

import helper.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static helper.Grid.gridRemote;
import static helper.SauceLab.sauceLabRemote;

public class Driver {

    private static WebDriver driver;
    public static final String RUN_PROPERTY_FILE_PATH = "C:\\TC - Selenuim Java\\Project - Task1UnitTest" +
            "\\UnitTesting-master\\runProperties.json";
    private final static String CHROME_BROWSER = "CHROME";
    private final static String FIREFOX_BROWSER = "FIREFOX";
    private final static String REMOTE_SAUCE_LAB = "SAUCE_LAB";
    private final static String REMOTE_GRID = "GRID";


    public static WebDriver getDriver() {
        String machine = JsonReader.readFromJson(RUN_PROPERTY_FILE_PATH).get("machine").getAsString();
        if (driver == null) {
            if (machine.equals("LOCAL")) {
                String browser = JsonReader.readFromJson(RUN_PROPERTY_FILE_PATH).get("browser").getAsString();
                if (browser.equals(CHROME_BROWSER)) {
                    WebDriverManager.getInstance(ChromeDriver.class).setup();
                    driver = new ChromeDriver();
                } else if (browser.equals(FIREFOX_BROWSER)) {
                    WebDriverManager.getInstance(FirefoxDriver.class).setup();
                    driver = new FirefoxDriver();
                }
            } else if(machine.equals("REMOTE")) {
                String remoteOption = JsonReader.readFromJson(RUN_PROPERTY_FILE_PATH).get("remoteOption").getAsString();
                if (remoteOption.equals(REMOTE_SAUCE_LAB)) {
                    driver = sauceLabRemote();
                } else if (remoteOption.equals(REMOTE_GRID)) {
                    driver = gridRemote();
                }
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
