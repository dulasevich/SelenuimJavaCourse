package tests;

import dto.User;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.accountPages.WelcomeAccountPage;

import static helper.TestUtils.getUser;
import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {
    private final static String LOGIN = RandomStringUtils.randomAlphanumeric(10) + "@mail.ru";
    private final static String ACCOUNT_WELCOME_TEXT = "Welcome to your account. " +
            "Here you can manage all of your personal information and orders.";

    @Description("Test case verifies the ability to create an account")
    @TmsLink("AP1")
    @Test(priority = 1)
    void createAccountTest(){
        User user = getUser(0);
        LoginPage loginPage = homePage.goToLoginScreen();
        CreateAccountPage createAccountPage = loginPage.createAccount(LOGIN);
        WelcomeAccountPage accountPage = createAccountPage.registerAccount(user);
        assertEquals(accountPage.getAccountGreetingText(), ACCOUNT_WELCOME_TEXT);
    }
}
