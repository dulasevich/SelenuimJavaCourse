package by;

import org.openqa.selenium.By;

public class Variables {
    public static By loginButton = By.linkText("Log in");
    public static By loginField = By.name("login");
    public static By passwordField = By.id("passp-field-passwd");
    public static By emailsCheckbox = By.className("mail-Toolbar-Item-Checkbox");
    public static By writeEmailButton = By.partialLinkText("Напи");
    public static By forwardEmailIcon = By.xpath("//div[contains(@data-key, 'forward')]");
    public static By pageTitle = By.tagName("title");
    public static By currentDate = By.cssSelector("span[class$='ToggleWidget-DayOfMonth']");
}
