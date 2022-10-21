package pages;

import driver.Driver;
import helper.PageUtils;
import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.accountPages.WelcomeAccountPage;
import sections.Header;

public class BasePage {

    protected WebDriver driver;
    protected Header header;
    protected PageUtils pageUtils;
    protected Waiter waiter;

    public BasePage() {
        driver = Driver.getDriver();
        pageUtils = new PageUtils(driver);
        header = new Header(driver);
        waiter = new Waiter(driver);
    }

    @Step("Navigate to login")
    public LoginPage goToLoginScreen() {
        header.clickLoginButton();
        return new LoginPage();
    }

    @Step("Navigate to cart")
    public CartPage goToCart() {
        header.clickCartButton();
        return new CartPage();
    }

    @Step("Navigate to account")
    public WelcomeAccountPage goToAccount() {
        header.clickAccountButton();
        return new WelcomeAccountPage();
    }
}
