package helper;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static void waitForElementVisibility(By element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions
                .visibilityOfElementLocated(element));
    }
}
