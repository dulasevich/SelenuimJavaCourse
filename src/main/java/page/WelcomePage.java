package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {

    private final static By LOGIN_BUTTON = By.linkText("Log in");

    public WelcomePage() {
        super();
    }

    public LoginPage navigateToLoginScreen() {
        final WebElement loginOption = driver.findElement(LOGIN_BUTTON);
        loginOption.click();
        return new LoginPage();
    }

    public WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }
}
