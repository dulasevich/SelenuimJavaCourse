package by;

import org.openqa.selenium.By;

public class Variables {
    public static By loginButton = By.linkText("Log in");
    public static By loginField = By.name("login");
    public static By passwordField = By.id("passp-field-passwd");
    public static By emailsCheckbox = By.className("mail-Toolbar-Item-Checkbox");
    public static By writeEmailButton = By.partialLinkText("Напи");
    public static By forwardEmailIcon = By.xpath("//div[@data-key='view=toolbar-button-forward&threaded=yes&current_folder=1&sort_type=date&with_pins=yes&layout=messages&id=forward']");
    public static By pageTitle = By.tagName("title");
    public static By currentDate = By.cssSelector("span[class^='Text Text_weight_bold ToggleWidget-DayOfMonth']");
}
