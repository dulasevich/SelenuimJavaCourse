package helper;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid {

    public static final String URL = "http://localhost:4444";
    public static ChromeOptions browserOptions = new ChromeOptions();


    public static RemoteWebDriver gridRemote() {
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(URL), browserOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return remoteWebDriver;
    }
}
