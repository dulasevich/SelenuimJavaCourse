import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;

import static by.Variables.*;
//Covers task 3
public class LoginTest {
    private final static String LOGIN = "testlands@yandex.by";
    private final static String PASSWORD = "JavaCourse1!";
    private final static Integer CURRENT_DATE = LocalDateTime.now().getDayOfMonth();
    private WebDriver driver;

    @BeforeEach
    void initializeDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.com/");
    }

    @Test
    void loginTest() throws InterruptedException {
        /* Thread sleep is type of implicity waiters, it just waits for the specific number of time before doing the next
        * action. The only different beetween Thread.sleep and timeouts().implicitlyWait is that Thread.sleep we need to
        * setup before each specific action we want to do next, while timeouts().implicitlyWait we can setup just once*/
        Thread.sleep(1000);

        WebElement logIntoExistingAccount = driver.findElement(loginButton);
        logIntoExistingAccount.click();

        WebElement login = driver.findElement(loginField);
        login.sendKeys(LOGIN);
        login.submit();

        Thread.sleep(1000);

        WebElement password = driver.findElement(passwordField);
        password.sendKeys(PASSWORD);
        password.submit();

        Thread.sleep(3000);

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