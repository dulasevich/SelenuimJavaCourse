package page;

import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MailBoxPage extends BasePage {

    private final static By USER_LOGO = By.xpath("//a[contains(@class, 'legouser')]/div[contains(@class, 'user-pic')]");
    private final static By LOGOUT_LINK = By.cssSelector(".legouser__menu-item_action_exit");

    public MailBoxPage() {
        super();
    }

    public WelcomePage logoutFromAccount() {
        Waiter.waitForElementVisibility(USER_LOGO);
        final WebElement userLogo = driver.findElement(USER_LOGO);
        userLogo.click();
        final WebElement logoutLink = driver.findElement(LOGOUT_LINK);
        logoutLink.click();
        return new WelcomePage();
    }
}
