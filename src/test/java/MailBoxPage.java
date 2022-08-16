import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(@class, 'legouser')]/div[contains(@class, 'user-pic')]")
    private WebElement userLogo;

    @FindBy(linkText = "Выйти из сервисов Яндекса")
    private WebElement logoutButton;

    public MailBoxPage() {
        this.driver = WebDriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public WelcomePage logoutFromAccount() {
        userLogo.click();
        logoutButton.click();
        return new WelcomePage();
    }
}
