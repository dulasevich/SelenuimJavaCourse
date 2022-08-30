package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Firefox
            WebDriverManager.getInstance(FirefoxDriver.class).setup();
            FirefoxProfile f = new FirefoxProfile();
            f.setPreference("browser.download.dir", "C:\\AutoDownloadFolders\\FireFox");
            f.setPreference("browser.download.folderList", 2);
            f.setPreference("browser.helperApps.alwaysAsk.force", false);
            f.setPreference("browser.download.manager.showWhenStarting", false);
            f.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip, application/x-zip, application/x-zip-compressed”)");
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(f);
            driver = new FirefoxDriver(options);


            /*Chrome
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", "C:\\AutoDownloadFolders\\Chrome");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
            */

            /*
            WebDriverManager.getInstance(EdgeDriver.class).setup();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", "C:\\AutoDownloadFolders\\Edge");
            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("prefs", prefs);
            driver = new EdgeDriver(options);
            */
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
