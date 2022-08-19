import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.*;

public class LogOutTest extends BaseTest {

    @Test
    void logoutTest() {
        LoginPage loginPage = welcomePage.navigateToLoginScreen();
        loginPage.enterLogin();
        MailBoxPage mailBoxPage = loginPage.enterPassword();
        WelcomePage welcomePage = mailBoxPage.logoutFromAccount();
        Assertions.assertTrue(welcomePage.getLoginButton().isDisplayed());
    }
}
