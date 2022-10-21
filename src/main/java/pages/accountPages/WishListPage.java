package pages.accountPages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.ProductPage;

public class WishListPage extends BasePage {

    @FindBy(xpath = ".//li[@class ='clearfix']/a")
    private WebElement productFromTopSellersLink;

    @FindBy(css = "#block-history")
    private WebElement wishListSectionBlock;

    @FindBy(xpath = ".//a[contains(text(),'View')]")
    private WebElement viewWishListLink;

    @FindBy(css = "#s_title")
    private WebElement productFromWishListTitle;

    @FindBy(css = ".icon-remove")
    private WebElement deleteWishListIcon;

    @FindBy(id = "name")
    private WebElement wishListNameField;

    @FindBy(id = "submitWishlist")
    private WebElement saveWishListButton;

    public WishListPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Check user has NO wish list created")
    public boolean checkIfWishListExists() {
        return pageUtils.isDisplayed(wishListSectionBlock);
    }

    @Step("Click wish list")
    public void viewWishList() {
        waiter.waifForWebElementVisibility(viewWishListLink);
        viewWishListLink.click();
    }

    @Step("Get product name from the wish list")
    public String getWishListProductName() {
        waiter.waifForWebElementVisibility(productFromWishListTitle);
        return productFromWishListTitle.getText();
    }

    @Step("Create wish list")
    public void createWishList(String wishName) {
        waiter.waifForWebElementVisibility(wishListNameField);
        wishListNameField.sendKeys(wishName);
        saveWishListButton.click();
    }

    @Step("Delete wish list")
    public void DeleteWishList() {
        waiter.waifForWebElementVisibility(deleteWishListIcon);
        deleteWishListIcon.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Step("Go to product page")
    public ProductPage goToProductPage() {
        waiter.waifForWebElementVisibility(productFromTopSellersLink);
        productFromTopSellersLink.click();
        return new ProductPage();
    }
}
