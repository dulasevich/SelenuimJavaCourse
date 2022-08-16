import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}