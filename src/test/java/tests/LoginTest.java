package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.accountPages.WelcomeAccountPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    private final static String LOGIN = "dulasev@mail.ru";
    private final static String PASSWORD = "qaz123";
    private final static String ACCOUNT_WELCOME_TEXT = "Welcome to your account. " +
            "Here you can manage all of your personal information and orders.";

    @Description("Test case verifies the ability to login into account")
    @TmsLink("AP2")
    @Test()
    void loginTest(){
        LoginPage loginPage = homePage.goToLoginScreen();
        WelcomeAccountPage accountPage = loginPage.login(LOGIN, PASSWORD);
        assertEquals(accountPage.getAccountGreetingText(), ACCOUNT_WELCOME_TEXT);
    }
}
