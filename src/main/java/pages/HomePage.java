package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import strategy.GoToProductPage;

public class HomePage extends BasePage implements GoToProductPage {

    @FindBy(xpath = "//ul[@id='homefeatured']/li[6]")
    private WebElement homePageSomeProduct;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Go to product page")
    public ProductPage goToProductPage() {
        homePageSomeProduct.click();
        return new ProductPage();
    }
}