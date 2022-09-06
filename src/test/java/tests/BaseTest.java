package tests;

import driver.Driver;
import helper.TestFailure;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import page.WelcomePage;

import java.time.Duration;

@Epic("Yandex mail tests")
@ExtendWith(TestFailure.class)
public class BaseTest {

    private WebDriver driver;
    private final static String URL = "https://mail.yandex.com/";
    protected WelcomePage welcomePage;

    @BeforeEach
    void initializeDriver() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get(URL);
        welcomePage = new WelcomePage();
    }

    @AfterEach
    void closeBrowser() {
        Driver.turnDriverDown();
    }
}