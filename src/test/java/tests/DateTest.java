package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MailBoxPage;

import java.time.LocalDateTime;

public class DateTest extends BaseTest {

    private final static String LOGIN = "aaa1230912";
    private final static String PASSWORD = "qazwsxT12345";
    private final static Integer date = LocalDateTime.now().getDayOfMonth() + 1;

    @TmsLink(value = "INT-15")
    @Feature("Mailbox Page")
    @DisplayName("Mailbox Date")
    @Description("Test case verifies whether the current date on the mailbox page " +
            "equals to the custom one")
    @Test
    void dateTest(){
        LoginPage loginPage = welcomePage.navigateToLoginScreen();
        MailBoxPage mailBoxPage = loginPage.login(LOGIN, PASSWORD);
        String welcomePageDate = mailBoxPage.getCurrentDate();
        Assertions.assertEquals(date.toString(), welcomePageDate);
    }
}
