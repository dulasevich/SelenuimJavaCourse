package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    private final static String LOGIN = "aaa1230912";
    private final static String PASSWORD = "qazwsxT12345";

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void enterLogin() {
        loginField.sendKeys(LOGIN);
        loginField.submit();
    }

    public MailBoxPage enterPassword() {
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
        return new MailBoxPage();
    }
}
