package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(xpath = ".//*[@itemprop = 'name']")
    private WebElement productName;

    @FindBy(id = "wishlist_button")
    private WebElement addToWishListButton;

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
        waiter.waifForWebElementVisibility(addToWishListButton);
        addToWishListButton.click();
    }
}

