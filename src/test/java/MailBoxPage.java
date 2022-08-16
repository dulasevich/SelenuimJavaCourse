import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailBoxPage {

    private final static By USER_LOGO = By.xpath("//a[contains(@class, 'legouser')]/div[contains(@class, 'user-pic')]");
    private final static By LOGOUT_LINK = By.linkText("Выйти из сервисов Яндекса");

    private final WebDriver driver;

    public MailBoxPage() {
        this.driver = WebDriverSingleton.getInstance();
    }

    public WelcomePage logoutFromAccount() {
        final WebElement userLogo = driver.findElement(USER_LOGO);
        userLogo.click();
        final WebElement logoutLink = driver.findElement(LOGOUT_LINK);
        logoutLink.click();
        return new WelcomePage();
    }
}
