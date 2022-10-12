package pages;

import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.accountPages.WelcomeAccountPage;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement productName;

    @FindBy(id = "wishlist_button")
    private WebElement addToWishListButton;

    @FindBy(css = ".account")
    private WebElement accountButton;

    @FindBy(css = "#add_to_cart button")
    private WebElement addToCartButton;

    @FindBy(css = ".icon-ok")
    private WebElement productAddedConfirmPopUp;

    @FindBy (css = ".continue")
    private WebElement continueShoppingButton;

    public ProductPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Get product name from product page")
    public String getProductName() {
        return productName.getText();
    }

    @Step("Add product to wish list")
    public void addProductToWishList() {
        Waiter.waifForWebElementVisibility(addToWishListButton);
        addToWishListButton.click();
    }

    @Step("Navigate to account")
    public WelcomeAccountPage goToAccount() {
        Waiter.waifForWebElementVisibility(accountButton);
        accountButton.click();
        return new WelcomeAccountPage();
    }

    @Step("Add product to the cart")
    public void addProductToCart() {
        Waiter.waifForWebElementVisibility(addToCartButton);
        addToCartButton.click();
        Waiter.waifForWebElementVisibility(productAddedConfirmPopUp);
        continueShoppingButton.click();
        Waiter.waifForWebElementInVisibility(productAddedConfirmPopUp);
    }
}

