package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.fail;

public class HomePage extends BasePage {

    @FindBy(css = "#homefeatured li")
    private List<WebElement> products;

    @FindBy(xpath = ".//*[@class='button-container']/a[@title='Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = ".//*[@title = 'Continue shopping']")
    private WebElement continueShoppingButton;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void addProductByPosition(int position) {
        if (position > products.size()) {
            fail("Current max possible position should be less than " + products.size() +
                    ". Product at this position does not exist on home page");
        }
        WebElement product = products.get(position);
        waiter.waifForWebElementVisibility(product);
        pageUtils.scrollToElement(product);
        pageUtils.hoverOverElement(product);
        waiter.waifForWebElementVisibility(addToCartButtons.get(position));
        addToCartButtons.get(position).click();
        waiter.waifForWebElementVisibility(continueShoppingButton);
        continueShoppingButton.click();
    }
}