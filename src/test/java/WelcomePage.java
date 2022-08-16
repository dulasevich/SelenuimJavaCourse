import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    private final static String URL = "https://mail.yandex.com/";
    private final WebDriver driver;

    @FindBy(linkText = "Log in")
    private WebElement loginButton;

    public WelcomePage() {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);

        this.driver.manage().window().maximize();
        this.driver.get(URL);
    }

    public LoginPage logIntoAccount() {
        loginButton.click();
        return new LoginPage();
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
