import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    private final static String PASSWORD = "JavaCourse2!";
    private final WebDriver driver;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordField;

    public PasswordPage() {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public MailBoxPage enterPassword() {
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
        return new MailBoxPage();
    }
}
