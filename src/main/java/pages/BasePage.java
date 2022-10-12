package pages;

import driver.Driver;
import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.accountPages.WelcomeAccountPage;

public class BasePage {

    protected final WebDriver driver;

    @FindBy(css = ".login")
    private WebElement signInButton;

    @FindBy(css = ".account")
    private WebElement accountButton;

    @FindBy(xpath = "//*[@class='shopping_cart']/a")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    private WebElement dressesFromBar;

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    @Step("Navigate to login")
    public LoginPage navigateToLoginScreen() {
        Waiter.waifForWebElementVisibility(signInButton);
        signInButton.click();
        return new LoginPage();
    }

    @Step("Navigate to account")
    public WelcomeAccountPage navigateToAccount() {
        accountButton.click();
        return new WelcomeAccountPage();
    }

    @Step("Navigate to cart")
    public CartPage navigateToCart() {
        cartButton.click();
        return new CartPage();
    }

    @Step("Navigate To Index Page")
    public IndexPage goToIndexPage() {
        Waiter.waifForWebElementVisibility(dressesFromBar);
        dressesFromBar.click();
        return new IndexPage();
    }
}
