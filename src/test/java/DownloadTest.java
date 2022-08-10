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

//Covers task 8
public class DownloadTest {

    private WebDriver driver;

    @BeforeEach
    void initializeBrowser() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
    }

    @Test
    void downloadTest() {
        WebElement clickDownload = driver.findElement(By.cssSelector("#cricle-btn"));
        clickDownload.click();

        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.textToBePresentInElement(driver.findElement(percent), "50%"));

        driver.navigate().refresh();

        Assertions.assertEquals("0%", driver.findElement(percent).getText());
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}

