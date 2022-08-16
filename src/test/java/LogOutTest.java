import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LogOutTest {
    private WebDriver driver;
    private WelcomePage welcomePage;

    @BeforeEach
    void initializeDriver() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    void logoutTest() {
        welcomePage = new WelcomePage();
        LoginPage loginPage = welcomePage.logIntoAccount();
        PasswordPage passwordPage = loginPage.login();
        MailBoxPage mailBoxPage = passwordPage.enterPassword();
        WelcomePage welcomePage = mailBoxPage.logoutFromAccount();
        Assertions.assertTrue(welcomePage.getLoginButton().isDisplayed());
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
