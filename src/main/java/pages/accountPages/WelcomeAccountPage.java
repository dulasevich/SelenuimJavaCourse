package pages.accountPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class WelcomeAccountPage extends BasePage {

    @FindBy(className = "info-account")
    private WebElement accountWelcomeText;

    @FindBy(css = ".lnk_wishlist")
    private WebElement myWishlistButton;

    public WelcomeAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Get Account Welcome Text")
    public String getAccountGreetingText() {
        waiter.waifForWebElementVisibility(accountWelcomeText);
        return accountWelcomeText.getText();
    }

    @Step("Navigate to account wish list")
    public WishListPage goToWishList() {
        waiter.waifForWebElementVisibility(myWishlistButton);
        myWishlistButton.click();
        return new WishListPage();
    }
}
