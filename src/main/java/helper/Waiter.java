package helper;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static void waifForWebElementVisibility(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
