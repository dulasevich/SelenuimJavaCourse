package pages;

import driver.Driver;
import helper.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    private By productsInCart = By.xpath("//tr[contains(@class, 'cart_item')]");

    @FindBy(id = "cart_title")
    private WebElement cartWelcomeText;

    @FindBy( css = "#summary_products_quantity")
    private WebElement cartProductsNumber;

    @FindBy(xpath = "//a[@class='cart_quantity_delete'][1]")
    private WebElement delete;

    @FindBy(css = ".alert-warning")
    private WebElement emptyBagText;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public String getCartProductsNumber() {
        Waiter.waifForWebElementVisibility(cartWelcomeText);
        return cartProductsNumber.getText();
    }

    public void cleanProducts() {
        Waiter.waifForWebElementVisibility(delete);
        List<WebElement> deleteIconsInCart = Driver.getDriver().findElements(By.cssSelector(".icon-trash"));
        for (int i = 0; i<deleteIconsInCart.size(); i++) {
            Waiter.waifForNumberOfElementsToBe(productsInCart, deleteIconsInCart.size()-i);
            delete.click();
        }
        Waiter.waifForWebElementVisibility(emptyBagText);
    }
}
