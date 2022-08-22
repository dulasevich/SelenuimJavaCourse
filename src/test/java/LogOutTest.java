import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MailBoxPage;
import page.WelcomePage;

public class LogOutTest extends BaseTest{

    private final static String LOGIN = "aaa1230912";
    private final static String PASSWORD = "qazwsxT12345";

    @Test
    void logoutTest() {
        LoginPage loginPage = welcomePage.navigateToLoginScreen();
        loginPage.enterLogin(LOGIN);
        MailBoxPage mailBoxPage = loginPage.enterPassword(PASSWORD);
        WelcomePage welcomepage = mailBoxPage.logoutFromAccount();
        Assertions.assertTrue(welcomepage.getLoginButton().isDisplayed());
    }
}