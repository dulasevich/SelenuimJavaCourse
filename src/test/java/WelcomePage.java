import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {

    private final static String URL = "https://mail.yandex.com/";
    private final static By LOGIN_BUTTON = By.linkText("Log in");

    private final WebDriver driver;

    public WelcomePage() {
        this.driver = WebDriverSingleton.getInstance();

        this.driver.manage().window().maximize();
        this.driver.get(URL);
    }

    public LoginPage logIntoAccount() {
        final WebElement loginOption = driver.findElement(LOGIN_BUTTON);
        loginOption.click();
        return new LoginPage();
    }

    public WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }
}
