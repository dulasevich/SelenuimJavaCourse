package pages;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import sections.Header;

public class BasePage {

    protected final WebDriver driver;
    private Header header;

    public BasePage() {
        this.driver = Driver.getDriver();
        this.header = new Header();
    }

    @Step("Navigate to header section")
    public Header navigateToHeader() {
        return header;
    }
}
