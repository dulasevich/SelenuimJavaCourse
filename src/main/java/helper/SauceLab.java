package helper;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class SauceLab {

    public static final String USERNAME = "ulasevichdmitry:";
    public static final String ACCESS_KEY = "83774cb8-efed-427f-8051-8769d5e4b883";
    public static final String URL = "https://" + USERNAME + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static Capabilities sauceLabCloudCombination(Integer option) {
        switch (option) {
            case 1: {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 10");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Task120SauceLab.1");
                sauceOptions.put("name", "ulasevichdmitry");
                browserOptions.setCapability("sauce:options", sauceOptions);
                return browserOptions;
            }
            case 2: {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 8.1");
                browserOptions.setBrowserVersion("81");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Task120SauceLab.2");
                sauceOptions.put("name", "ulasevichdmitry");
                browserOptions.setCapability("sauce:options", sauceOptions);
                return browserOptions;
            }
            case 3: {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("macOS 11.00");
                browserOptions.setBrowserVersion("98");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("build", "Task120SauceLab.3");
                sauceOptions.put("name", "ulasevichdmitry");
                browserOptions.setCapability("sauce:options", sauceOptions);
                return browserOptions;
            }
            default: { //what's the best idea for default case?
                System.out.println("Incorrect option entered, by default test(s) will run on Win 11, Chrome 84");
                return new ChromeOptions().setPlatformName("Windows 11").setBrowserVersion("84");
            }
        }
    }
}
