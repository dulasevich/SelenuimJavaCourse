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

import java.time.LocalDateTime;

public class DateTest extends BaseTest {

    private final static String LOGIN = "aaa1230912";
    private final static String PASSWORD = "qazwsxT12345";
    private final static Integer date = LocalDateTime.now().getDayOfMonth() + 1;

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

    @Step("3. Get Current date from the Welcome Page")
    private String getCurrentDateFromWelcomePage() {
        MailBoxPage mailBoxPage = new MailBoxPage();
        return mailBoxPage.getCurrentDate();
    }

    @Feature("Mailbox Page")
    @DisplayName("ID-1-Mailbox_Date")
    @Description("Test case verifies whether the current date on the mailbox page " +
            "equals to the custom one")
    @Test
    @Order(1)
    void dateTest(){
        navToLogin();
        login();
        String welcomePageDate = getCurrentDateFromWelcomePage();
        Assertions.assertEquals(date.toString(), welcomePageDate);
    }
}
