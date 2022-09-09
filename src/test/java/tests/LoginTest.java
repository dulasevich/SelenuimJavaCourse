package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MailBoxPage;

public class LoginTest extends BaseTest {

    private final static String LOGIN = "notRealForTestToFail";
    private final static String PASSWORD = "blablabla";

    @TmsLink(value = "INT-22")
    @Feature("Mailbox Page")
    @DisplayName("Mailbox Login UserLogo")
    @Description("Test case verifies if user can login to the account with credentials which do not exist")
    @Test
    void loginTest(){
        LoginPage loginPage = welcomePage.navigateToLoginScreen();
        MailBoxPage mailBoxPage = loginPage.login(LOGIN, PASSWORD);
        Assertions.assertTrue(mailBoxPage.getUserLogo().isDisplayed());
    }
}
