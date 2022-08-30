import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.*;

public class LogOutTest extends BaseTest {

    private final static String LOGIN = "aaa1230912";
    private final static String PASSWORD = "qazwsxT12345";
    private final static String URL = "https://mail.yandex.com/";

    @Test
    void logoutTest() {
        driver.get(URL);
        LoginPage loginPage = welcomePage.navigateToLoginScreen();
        loginPage.enterLogin(LOGIN);
        MailBoxPage mailBoxPage = loginPage.enterPassword(PASSWORD);
        mailBoxPage.makeHomePageScreenshot();
        WelcomePage welcomePage = mailBoxPage.logoutFromAccount();
        Assertions.assertTrue(welcomePage.getLoginButton().isDisplayed());
    }
}
