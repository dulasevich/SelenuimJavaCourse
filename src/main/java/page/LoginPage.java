package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final static By LOGIN_FIELD = By.name("login");
    private final static By PASSWORD_FIELD = By.id("passp-field-passwd");

    public LoginPage() {
        super();
    }

    public void enterLogin(String login) {
        final WebElement loginField = driver.findElement(LOGIN_FIELD);
        loginField.sendKeys(login);
        loginField.submit();
    }

    public MailBoxPage enterPassword(String password) {
        final WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(password);
        passwordField.submit();
        return new MailBoxPage();
    }
}