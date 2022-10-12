package pages;

import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import strategy.GoToProductPage;

public class IndexPage extends BasePage implements GoToProductPage {

    @FindBy(css = ".right-block h5 a")
    private WebElement firstProductOnIndexPage;

    public IndexPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Go to product page")
    public ProductPage goToProductPage() {
        Waiter.waifForWebElementVisibility(firstProductOnIndexPage);
        firstProductOnIndexPage.click();
        return new ProductPage();
    }
}
