package page;

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

    public LoginPage navigateToLoginScreen() {
        loginButton.click();
        return new LoginPage();
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}