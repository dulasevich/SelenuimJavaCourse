package helper;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtils {

    private Actions actions;

    public PageUtils(WebDriver driver) {
        actions = new Actions(driver);
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scrollToElement(WebElement element) {
        if(System.getProperty("browser").equals("firefox")) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        } else {
            actions.scrollToElement(element).build().perform();
        }
    }

    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }
}
