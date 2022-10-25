package driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browsers {

    public static Capabilities getCapabilities(String browser) {
        switch (browser) {
            case "chrome" :
                return getChromeCapabilities();
            case "firefox" :
                return getFireFoxCapabilities();
            case "edge" :
                return getEdgeCapabilities();
        }
        return null;
    }

    private static ChromeOptions getChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("os", "Windows");
        return options;
    }
    private static FirefoxOptions getFireFoxCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("os", "Windows");
        return options;
    }

    private static EdgeOptions getEdgeCapabilities() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("os", "Windows");
        return options;
    }
}
