import by.Variables;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    void loginTest() {
        /* Thread sleep is type of implicity waiters, it just waits for the specific number of time before doing the next
        * action. The only different beetween Thread.sleep and timeouts().implicitlyWait is that Thread.sleep we need to
        * setup before each specific action we want to do next, while timeouts().implicitlyWait we can setup just once*/

        //Thread.sleep(1000);

        WebElement logIntoExistingAccount = driver.findElement(LOGIN_BUTTON);
        logIntoExistingAccount.click();
        WebElement login = driver.findElement(LOGIN_FIELD);
        login.sendKeys(LOGIN);
        login.submit();
        WebElement password = driver.findElement(PASSWORD_FIELD);
        password.sendKeys(PASSWORD);
        password.submit();
        WebElement checkbox = driver.findElement(EMAILS_CHECKBOX);
        checkbox.click();
        WebElement writeEmail = driver.findElement(WRITE_EMAIL_BUTTON);
        WebElement forwardEmail = driver.findElement(FORWARD_EMAIL_ICON);
        WebElement title = driver.findElement(PAGE_TITLE);
        WebElement date = driver.findElement(Variables.CURRENT_DATE);
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