import driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import page.WelcomePage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WelcomePage welcomePage;

    @BeforeEach
    void initializeDriver() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        //driver.get(URL);
        welcomePage = new WelcomePage();
    }

    @AfterEach
    void closeBrowser() {
        Driver.turnDriverDown();
    }
}
