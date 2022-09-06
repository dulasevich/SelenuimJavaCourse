package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MailBoxPage;

public class LoginTest extends BaseTest {

    private final static String LOGIN = "notRealForTestToFail";
    private final static String PASSWORD = "blablabla";

    @Step("1. Navigate to Login screen")
    private void navToLogin() {
        welcomePage.navigateToLoginScreen();
    }

    @Step("2. Log into account")
    private void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin(LOGIN);
        loginPage.enterPassword(PASSWORD);
    }

    @Step("3. Check if user logo displays on Welcome page after the loging")
    private boolean checkIfWelcomePagDisplays() {
        MailBoxPage mailBoxPage = new MailBoxPage();
        return mailBoxPage.getUserLogo().isDisplayed();
    }

    @Feature("Mailbox Page")
    @DisplayName("ID-2-Mailbox_Login_UserLogo")
    @Description("Test case verifies if user can login to the account with credentials which do not exist")
    @Test
    @Order(2)
    void loginTest(){
        navToLogin();
        login();
        Assertions.assertTrue(checkIfWelcomePagDisplays());
    }

    /*
    * Questions about allure:
    * 1. 'Allure serve' working, report opens, but 'allure report' does not, file generated, but does not show info
    * 2. @Order does not work?
    * 3. Should we add Allure files should to gitignore? I added '.allure' and 'allure-results', is that correct?
    * Question about tests in general:
    * 1. Chrome - Passed one shows exception 'SocketException:Connection reset'. Though does not affect allure report
    * 2. Test seems to become slower after adding allure, am I wrong?
    * 3. Lots of processes (drivers and java) seems to be added in the background, is that ok? How to prevent?
    * */
}
