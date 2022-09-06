package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MailBoxPage;
import page.WelcomePage;

public class LogOutTest extends BaseTest {

    private final static String LOGIN = "aaa1230912";
    private final static String PASSWORD = "qazwsxT12345";

    @Feature("Welcome Page")
    @DisplayName("ID-3-WelcomePage_after-logout")
    @Description("Test case verifies user is able to login to account and logout from that next")
    @Test
    @Order(3)
    void logoutTest() {
        LoginPage loginPage = welcomePage.navigateToLoginScreen();
        loginPage.enterLogin(LOGIN);
        MailBoxPage mailBoxPage = loginPage.enterPassword(PASSWORD);
        mailBoxPage.makeHomePageScreenshot();
        WelcomePage welcomePage = mailBoxPage.logoutFromAccount();
        Assertions.assertTrue(welcomePage.getLoginButton().isDisplayed());
    }
}
