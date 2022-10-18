package pages;

import helper.Waiter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
        Actions actions = new Actions(driver);
            if (position < products.size()) {
                Waiter.waifForWebElementVisibility(products.get(position));

                if(System.getProperty("browser").equals("firefox")) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", products.get(position));
                } else {
                    actions.scrollToElement(products.get(position)).build().perform();
                }
                actions.moveToElement(products.get(position)).build().perform();
                Waiter.waifForWebElementVisibility(addToCartButtons.get(position));
                addToCartButtons.get(position).click();
                Waiter.waifForWebElementVisibility(continueShoppingButton);
                continueShoppingButton.click();
            } else {
                System.out.println("Current max possible position should be less than " + products.size() +
                        ". Product at this position does not exist on home page. Going to the cart");
            }
    }
}