package page;

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

    public void enterLogin(String login) {
        loginField.sendKeys(login);
        loginField.submit();
    }

    public MailBoxPage enterPassword(String password) {
        passwordField.sendKeys(password);
        passwordField.submit();
        return new MailBoxPage();
    }
}
