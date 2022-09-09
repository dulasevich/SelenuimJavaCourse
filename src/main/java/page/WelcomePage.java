package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage{

    @FindBy(css = ".PSHeader-NoLoginButton")
    private WebElement loginButton;

    public WelcomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Navigate to login")
    public LoginPage navigateToLoginScreen() {
        loginButton.click();
        return new LoginPage();
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}