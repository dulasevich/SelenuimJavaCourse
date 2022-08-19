package page;

import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxPage extends BasePage{

    private static final By USER_LOGO = By.xpath("//a[contains(@class, 'legouser')]/div[contains(@class, 'user-pic')]");

    @FindBy(xpath = "//a[contains(@class, 'legouser')]/div[contains(@class, 'user-pic')]")
    private WebElement userLogo;

    @FindBy(css = ".legouser__menu-item_action_exit")
    private WebElement logoutButton;

    public MailBoxPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public WelcomePage logoutFromAccount() {
        Waiter.waifForWebElementVisibility(USER_LOGO);
        userLogo.click();
        logoutButton.click();
        return new WelcomePage();
    }
}
