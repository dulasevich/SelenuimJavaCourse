import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static by.Variables.*;

//Сovers task 7
public class UserTest {

    private WebDriver driver;

    @BeforeEach
    void initializeBrowser() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
    }

    @Test
    void userTest() {
        WebElement getUser = driver.findElement(By.cssSelector(".btn"));
        getUser.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(USER_IMAGE));
        Assertions.assertTrue(driver.findElement(USER_FIRST_NAME).isDisplayed());
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
