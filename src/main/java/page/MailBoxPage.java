package page;

import helper.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxPage extends BasePage{

    @FindBy(xpath = "//a[contains(@class, 'legouser')]/div[contains(@class, 'user-pic')]")
    private WebElement userLogo;

    @FindBy(css = ".legouser__menu-item_action_exit")
    private WebElement logoutButton;

    public MailBoxPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public WelcomePage logoutFromAccount() {
        Waiter.waifForWebElementVisibility(userLogo);
        userLogo.click();
        logoutButton.click();
        return new WelcomePage();
    }
}
