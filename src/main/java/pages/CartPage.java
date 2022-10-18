package pages;

import helper.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//tr[contains(@class, 'cart_item')]")
    private List<WebElement> products;

    @FindBy(id = "cart_title")
    private WebElement cartWelcomeText;

    @FindBy( css = "#summary_products_quantity")
    private WebElement cartProductsQuantity;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    private WebElement deleteButton;

    @FindBy(css = ".alert-warning")
    private WebElement emptyBagText;

    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public String getCartProductsQuantity() {
        Waiter.waifForWebElementVisibility(cartWelcomeText);
        return cartProductsQuantity.getText();
    }

    public void cleanProducts() {
        Waiter.waifForWebElementVisibility(deleteButton);
        int productsSize = products.size();
        for (int i = 0; i<productsSize; i++) {
            Waiter.waifForNumberOfElementsToBe(products, productsSize-i);
            deleteButton.click();
        }
        Waiter.waifForWebElementVisibility(emptyBagText);
    }
}
