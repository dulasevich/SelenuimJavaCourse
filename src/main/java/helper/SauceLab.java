package helper;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLab {

    public static final String USERNAME = "ulasevichdmitry:";
    public static final String ACCESS_KEY = "83774cb8-efed-427f-8051-8769d5e4b883";
    public static final String URL = "https://" + USERNAME + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    private static Capabilities sauceLab() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "Task120SauceLab.1");
        sauceOptions.put("name", "ulasevichdmitry");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }

    public static RemoteWebDriver sauceLabRemote() {
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(URL), sauceLab());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteWebDriver;
    }
}