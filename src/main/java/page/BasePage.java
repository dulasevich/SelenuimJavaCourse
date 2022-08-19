package page;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final WebDriver driver;

    public BasePage() {
        this.driver = Driver.getDriver();
    }
}
