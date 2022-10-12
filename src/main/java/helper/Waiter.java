package helper;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static void waifForWebElementVisibility(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30), Duration.ofMillis(100))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waifForWebElementInVisibility(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waifForNumberOfElementsToBe(By by, int number) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBe(by, number));
    }
}
