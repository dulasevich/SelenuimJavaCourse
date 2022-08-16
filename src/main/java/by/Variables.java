package by;

import org.openqa.selenium.By;

public class Variables {
    public final static By LOGIN_BUTTON = By.linkText("Log in");
    public final static By LOGIN_FIELD = By.name("login");
    public final static By PASSWORD_FIELD = By.id("passp-field-passwd");
    public final static By EMAILS_CHECKBOX = By.className("mail-Toolbar-Item-Checkbox");
    public final static By WRITE_EMAIL_BUTTON = By.partialLinkText("Напи");
    public final static By FORWARD_EMAIL_ICON = By.xpath("//div[contains(@data-key, 'forward')]");
    public final static By PAGE_TITLE = By.tagName("title");
    public final static By CURRENT_DATE = By.cssSelector("span[class$='ToggleWidget-DayOfMonth']");

    //task 40 new locators
    public final static By ACCOUNT_NAME = By.cssSelector("a[class*=\"user-account_left\"] .user-account__name");
    public final static By MAIL_ICON = By.xpath(".//span[text()='Почта' or text()='Mail']");
    public final static By ALERT_BOX = By.xpath(".//button[@onclick='myAlertFunction()']");
    public final static By JS_BOX = By.xpath(".//button[@onclick='myConfirmFunction()']");
    public final static By PROMPT_ALERT_BOX = By.xpath(".//button[@onclick='myPromptFunction()']");
    public final static By JS_RESULT = By.xpath(".//p[@id='confirm-demo']");
    public final static By PROMPT_RESULT = By.xpath(".//p[@id='prompt-demo']");
    public final static By USER_IMAGE = By.xpath(".//*[contains(@src, 'random')]");
    public final static By USER_FIRST_NAME = By.xpath(".//div[contains(text(), 'First Name')]");
    public final static By PERCENT_ICON = By.xpath(".//div[@class='percenttext']");
    public final static By TABLE_ROWS = By.xpath(".//tbody/tr");
    public final static By NEXT_PAGE_ICON = By.id("example_next");
    public final static By TABLE_NAME = By.xpath(".//td[1]");
    public final static By TABLE_POSITION = By.xpath(".//td[2]");
    public final static By TABLE_OFFICE = By.xpath(".//td[3]");
    public final static By TABLE_SALARY = By.xpath(".//td[6]");
    public final static By TABLE_AGE = By.xpath(".//td[4]");
    public final static By ITEMS_PER_PAGE = By.xpath(".//*[@name= 'example_length']");
    public final static By USA_STATES = By.xpath(".//*[@name='States']");
}
