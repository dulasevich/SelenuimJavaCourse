package tests;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTest {

    private WebDriver driver;
    private final static String URL = "http://automationpractice.com/index.php";
    protected HomePage homePage;

    @BeforeClass
    @Step("Navigate to Home page")
    void initializeDriver() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage();
    }

    @AfterClass
    void closeBrowser() {
        Driver.turnDriverDown();
    }
}