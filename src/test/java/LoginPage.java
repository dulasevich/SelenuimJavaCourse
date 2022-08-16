import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final static By LOGIN_FIELD = By.name("login");
    private final static String LOGIN = "testlands@yandex.by";

    private final WebDriver driver;

    public LoginPage() {
        this.driver = WebDriverSingleton.getInstance();
    }

    public PasswordPage login() {
        final WebElement loginField = driver.findElement(LOGIN_FIELD);
        loginField.sendKeys(LOGIN);
        loginField.submit();
        return new PasswordPage();
    }
}
