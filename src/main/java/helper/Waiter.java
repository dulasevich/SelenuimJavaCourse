package helper;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiter {

    public static void waifForWebElementVisibility(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(50), Duration.ofMillis(200))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waifForWebElementInVisibility(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30), Duration.ofMillis(200))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waifForNumberOfElementsToBe(List<WebElement> elements, int number) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20), Duration.ofMillis(200))
                .until(new ExpectedCondition<List<WebElement>>() {
                    @Override
                    public List<WebElement> apply(WebDriver webDriver) {
                        Integer currentNumber;
                        currentNumber = elements.size();
                        return currentNumber.equals(number) ? elements : null;
                    }
                });
    }
}
