package sections;

import helper.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private Waiter waiter;

    @FindBy(css = ".login")
    private WebElement signInButton;

    @FindBy(css = ".account")
    private WebElement accountButton;

    @FindBy(xpath = ".//*[@class='shopping_cart']/a")
    private WebElement cartButton;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waiter = new Waiter(driver);
    }

    public void clickLoginButton() {
        waiter.waifForWebElementVisibility(signInButton);
        signInButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickAccountButton() {
        waiter.waifForWebElementVisibility(accountButton);
        accountButton.click();
    }
}
