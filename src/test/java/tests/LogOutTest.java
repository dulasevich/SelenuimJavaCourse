package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MailBoxPage;
import page.WelcomePage;

public class LogOutTest extends BaseTest {

    private final static String LOGIN = "aaa1230912";
    private final static String PASSWORD = "qazwsxT12345";

    @TmsLink(value = "INT-34")
    @Feature("Welcome Page")
    @DisplayName("WelcomePage after logout")
    @Description("Test case verifies user is able to login to account and logout from that next")
    @Test
    void logoutTest() {
        LoginPage loginPage = welcomePage.navigateToLoginScreen();
        MailBoxPage mailBoxPage = loginPage.login(LOGIN, PASSWORD);
        mailBoxPage.makeHomePageScreenshot();
        WelcomePage welcomePage = mailBoxPage.logoutFromAccount();
        Assertions.assertTrue(welcomePage.getLoginButton().isDisplayed());
    }
}
