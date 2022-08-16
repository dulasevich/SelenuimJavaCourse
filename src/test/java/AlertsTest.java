import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static by.Variables.*;
//covers task 6
public class AlertsTest {
    private WebDriver driver;

    @BeforeEach
    void initializeDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
    }

    @Test
    void javaScriptAlertTest() {
        WebElement alertBox = driver.findElement(ALERT_BOX);
        alertBox.click();
        Assertions.assertTrue(driver.switchTo().alert().getText().equals("I am an alert box!"));
    }

    @Test
    void javaScriptBoxTest() {
        WebElement jsBox = driver.findElement(JS_BOX);
        jsBox.click();
        driver.switchTo().alert().accept();
        Assertions.assertTrue(driver.findElement(JS_RESULT).getText().equals("You pressed OK!"));
    }

    @Test
    void javaScriptAlertPromptTest() {
        final String sendKeys = "Dmitry";
        WebElement promptBox = driver.findElement(PROMPT_ALERT_BOX);
        promptBox.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(sendKeys);
        alert.accept();
        Assertions.assertEquals("You have entered '" + sendKeys + "' !",
                driver.findElement(PROMPT_RESULT).getText());
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}