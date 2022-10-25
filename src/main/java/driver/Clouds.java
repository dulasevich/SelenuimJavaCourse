package driver;

import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Clouds {

    private static RemoteWebDriver remoteWebDriver;

    public static final String GRID_URL = "http://localhost:4444";
    public static final String USERNAME = "ulasevichdmitry:";
    public static final String ACCESS_KEY = "83774cb8-efed-427f-8051-8769d5e4b883";
    public static final String SAUCE_URL = "https://" + USERNAME + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @SneakyThrows
    public static RemoteWebDriver getRemoteDriver(String cloud, Capabilities capabilities) {
        switch (cloud) {
            case "grid" :
                remoteWebDriver = new RemoteWebDriver(new URL(GRID_URL), capabilities);
            case "saucelab" :
                remoteWebDriver = new RemoteWebDriver(new URL(SAUCE_URL), capabilities);
        }
        return remoteWebDriver;
    }
}
