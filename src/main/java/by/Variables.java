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

    //task 40 new locators
    public static By accountName = By.xpath("//div[contains(@class, 'legouser')]/a/span[@class='user-account__name']");
    public static By mailIcon = By.xpath("//span[text()='Почта' or text()='Mail']");
    public static By alert = By.xpath("//button[@onclick='myAlertFunction()']");
    public static By js = By.xpath("//button[@onclick='myConfirmFunction()']");
    public static By prompt = By.xpath("//button[@onclick='myPromptFunction()']");
    public static By jsResult = By.xpath("//p[@id='confirm-demo']");
    public static By promptResult = By.xpath("//p[@id='prompt-demo']");
    public static By userImage = By.xpath("//*[contains(@src, 'random')]");
    public static By userFirstName = By.xpath("//div[contains(text(), 'First Name')]");
    public static By percent = By.xpath("//div[@class='percenttext']");
    public static By userName = By.xpath("//*[@role = 'row']/td[1]");
    public static By userPosition = By.xpath("//*[@role = 'row']/td[2]");
    public static By userOffice = By.xpath("//*[@role = 'row']/td[3]");
    public static By userAge = By.xpath("//*[@role = 'row']/td[4]");
    public static By userSalary = By.xpath("//*[@role = 'row']/td[6]");
    public static By pageTwo = By.xpath("//a[@class='paginate_button '][1]");
    public static By pageThree = By.xpath("//a[@class='paginate_button '][2]");
    public static By pageFour = By.xpath("//a[@class='paginate_button '][3]");
    public static By sort = By.xpath("//*[@name= 'example_length']");
    public static By states = By.xpath("//*[@name='States']");
}
