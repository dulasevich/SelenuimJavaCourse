import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDateTime;

import static by.Variables.*;

public class YandexTest {
    private final static String LOGIN = "testlands@yandex.by";
    private final static String PASSWORD = "JavaCourse1!";
    private final static Integer CURRENT_DATE = LocalDateTime.now().getDayOfMonth();
    private WebDriver driver;

    @BeforeEach
    void initializeDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://mail.yandex.com/");
    }

    @Test
    void loginTest() {
        WebElement logIntoExistingAccount = driver.findElement(loginButton);
        logIntoExistingAccount.click();

        WebElement login = driver.findElement(loginField);
        login.sendKeys(LOGIN);
        login.submit();

        WebElement password = driver.findElement(passwordField);
        password.sendKeys(PASSWORD);
        password.submit();

        WebElement checkbox = driver.findElement(emailsCheckbox);
        checkbox.click();

        WebElement writeEmail = driver.findElement(writeEmailButton);
        WebElement forwardEmail = driver.findElement(forwardEmailIcon);
        WebElement title = driver.findElement(pageTitle);
        WebElement date = driver.findElement(currentDate);

        Assertions.assertAll(() -> {
            Assertions.assertTrue(writeEmail.isDisplayed());
            Assertions.assertTrue(forwardEmail.isEnabled());
            Assertions.assertFalse(title.isDisplayed());
            Assertions.assertEquals(date.getText(), CURRENT_DATE.toString());
        });
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
