import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static by.Variables.*;
//Covers tasks 1, 2, 4
public class ParamsTest {
    private WebDriver driver;
    private final static String CREDENTIALS_1 = "testlands@yandex.by, JavaCourse1!";
    private final static String CREDENTIALS_2 = "aaa1230912, 1234567890!#)";

    @BeforeEach
    void initializeDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://mail.yandex.com/");
    }

    @ParameterizedTest()
    @CsvSource({CREDENTIALS_1, CREDENTIALS_2})
    void login (String l, String p){
        WebElement logIntoExistingAccount = driver.findElement(loginButton);
        logIntoExistingAccount.click();

        WebElement login = driver.findElement(loginField);
        login.sendKeys(l);
        login.submit();

        WebElement password = driver.findElement(passwordField);
        password.sendKeys(p);
        password.submit();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated
                (accountName));

        Assertions.assertTrue(driver.findElement(mailIcon).isDisplayed());
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}