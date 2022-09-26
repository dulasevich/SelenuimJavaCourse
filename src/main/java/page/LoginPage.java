package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Login to account")
    public MailBoxPage login(String login, String password) {
        loginField.sendKeys(login);
        loginField.submit();

        passwordField.sendKeys(password);
        passwordField.submit();

        return new MailBoxPage();
    }
}
