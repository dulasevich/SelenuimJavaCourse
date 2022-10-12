package pages.accountPages;

import driver.Driver;
import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.ProductPage;
import strategy.GoToProductPage;

import java.util.List;

public class WishListPage implements GoToProductPage {

    private WebDriver driver;

    @FindBy(xpath = "//li[@class ='clearfix'][2]/a")
    private WebElement productFromTopSellers;

    @FindBy(xpath = "//a[contains(text(),'View')]")
    private WebElement viewWishList;

    @FindBy(css = "#s_title")
    private WebElement productFromWishList;

    @FindBy(css = ".icon-remove")
    private WebElement deleteWishListIcon;

    @FindBy(id = "name")
    private WebElement wishListNameField;

    @FindBy(id = "submitWishlist")
    private WebElement saveWishList;

    public WishListPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Step("Check user has NO wish list created")
    public boolean checkIfWishListExists() {
        List<WebElement> wishList = driver.findElements(By.cssSelector("#block-history"));
        return wishList.size() > 0;
    }

    @Step("Click wish list")
    public void viewWishList() {
        Waiter.waifForWebElementVisibility(viewWishList);
        viewWishList.click();
    }

    @Step("Get product name from the wish list")
    public String getWishListProductName() {
        Waiter.waifForWebElementVisibility(productFromWishList);
        return productFromWishList.getText();
    }

    @Step("Create wish list")
    public void createWishList(String wishName) {
        Waiter.waifForWebElementVisibility(wishListNameField);
        wishListNameField.sendKeys(wishName);
        saveWishList.click();
    }

    @Step("Delete wish list")
    public void DeleteWishList() {
        Waiter.waifForWebElementVisibility(deleteWishListIcon);
        deleteWishListIcon.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    @Step("Go to product page")
    public ProductPage goToProductPage() {
        Waiter.waifForWebElementVisibility(productFromTopSellers);
        productFromTopSellers.click();
        return new ProductPage();
    }
}
