import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {

    private final static String PASSWORD = "JavaCourse2!";
    private final static By PASSWORD_FIELD = By.id("passp-field-passwd");

    private final WebDriver driver;

    public PasswordPage() {
        this.driver = WebDriverSingleton.getInstance();
    }

    public MailBoxPage enterPassword() {
        final WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
        return new MailBoxPage();
    }
}
