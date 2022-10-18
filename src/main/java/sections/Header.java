package sections;

import driver.Driver;
import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.LoginPage;
import pages.accountPages.WelcomeAccountPage;

public class Header {

    @FindBy(css = ".login")
    private WebElement signInButton;

    @FindBy(css = ".account")
    private WebElement accountButton;

    @FindBy(xpath = "//*[@class='shopping_cart']/a")
    private WebElement cartButton;

    public Header() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @Step("Navigate to login")
    public LoginPage goToLoginScreen() {
        Waiter.waifForWebElementVisibility(signInButton);
        signInButton.click();
        return new LoginPage();
    }

    @Step("Navigate to cart")
    public CartPage goToCart() {
        cartButton.click();
        return new CartPage();
    }

    @Step("Navigate to account")
    public WelcomeAccountPage goToAccount() {
        Waiter.waifForWebElementVisibility(accountButton);
        accountButton.click();
        return new WelcomeAccountPage();
    }
}
