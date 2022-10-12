package tests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import pages.accountPages.WelcomeAccountPage;

import static helper.AllureTestName.setTestName;
import static org.testng.Assert.assertEquals;

public class AccountTests extends BaseTest {
    private final static String LOGIN = RandomStringUtils.randomAlphanumeric(10) + "@mail.ru";
    private final String PASSWORD = "mnbvcxz0987654321";
    private final static String ACCOUNT_WELCOME_TEXT = "Welcome to your account. " +
            "Here you can manage all of your personal information and orders.";

    private WelcomeAccountPage accountPage;

    @Description("Test case verifies the ability to create an account")
    @Test(priority = 1)
    void createAccountTest(){
        setTestName("AP-1");
        LoginPage loginPage = homePage.navigateToLoginScreen();
        CreateAccountPage createAccountPage = loginPage.createAccount(LOGIN);
        accountPage = createAccountPage.registerAccount();
        assertEquals(accountPage.getAccountGreeting(), ACCOUNT_WELCOME_TEXT);
    }

    @Description("Test case verifies the ability to login into account")
    @Test(priority = 2)
    void loginTest(){
        setTestName("AP-2");
        accountPage.signOutFromAccount();
        LoginPage loginPage = homePage.navigateToLoginScreen();
        WelcomeAccountPage accountPage = loginPage.login(LOGIN, PASSWORD);
        assertEquals(accountPage.getAccountGreeting(), ACCOUNT_WELCOME_TEXT);
    }
}
