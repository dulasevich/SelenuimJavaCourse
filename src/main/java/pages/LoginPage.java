package pages;

import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.accountPages.WelcomeAccountPage;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailLoginField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signIntoAccountButton;

    @FindBy(id = "email_create")
    private WebElement emailCreateField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Login to account")
    public WelcomeAccountPage login(String login, String password) {
        Waiter.waifForWebElementVisibility(emailLoginField);
        emailLoginField.sendKeys(login);
        passwordField.sendKeys(password);
        signIntoAccountButton.click();

        return new WelcomeAccountPage();
    }

    @Step("Create account")
    public CreateAccountPage createAccount(String login) {
        Waiter.waifForWebElementVisibility(emailCreateField);
        emailCreateField.sendKeys(login);
        createAccountButton.click();

        return new CreateAccountPage();
    }

}
