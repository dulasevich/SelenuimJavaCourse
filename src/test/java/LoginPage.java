import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final static String LOGIN = "testlands@yandex.by";
    private final WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;

    public LoginPage() {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public PasswordPage login() {
        loginField.sendKeys(LOGIN);
        loginField.submit();
        return new PasswordPage();
    }
}
