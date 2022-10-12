package pages.accountPages;

import driver.Driver;
import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomeAccountPage {

    private final WebDriver driver;

    @FindBy(className = "info-account")
    private WebElement accountWelcomeText;

    @FindBy(css = ".logout")
    private WebElement signOutButton;

    @FindBy(css = ".lnk_wishlist")
    private WebElement myWishlistButton;

    public WelcomeAccountPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Step("Get Account Welcome Text")
    public String getAccountGreeting() {
        Waiter.waifForWebElementVisibility(accountWelcomeText);
        return accountWelcomeText.getText();
    }

    @Step("Sign out from the account")
    public void signOutFromAccount() {
        signOutButton.click();
    }

    @Step("Navigate to account wish list")
    public WishListPage navigateToWishList() {
        Waiter.waifForWebElementVisibility(myWishlistButton);
        myWishlistButton.click();
        return new WishListPage();
    }
}
