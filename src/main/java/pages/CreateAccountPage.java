package pages;

import driver.Driver;
import helper.JsonReader;
import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.accountPages.WelcomeAccountPage;

import java.time.Duration;

public class CreateAccountPage extends BasePage{

    public static final String USER_INFO_FILE_PATH = "C:\\TC - Selenuim Java\\Project - Task1UnitTest\\" +
            "UnitTesting-master\\src\\test\\resources\\userInfo.json";

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(css = "#passwd")
    private WebElement password;

    @FindBy(xpath = "//*[@id='address1']")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneNumber;

    public CreateAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Add personal information to register account")
    public WelcomeAccountPage registerAccount() {
        Waiter.waifForWebElementVisibility(firstName);

        firstName.sendKeys(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("firstname").getAsString());
        lastName.sendKeys(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("lastname").getAsString());
        password.sendKeys(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("pass").getAsString());
        address.sendKeys(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("address").getAsString());
        city.sendKeys(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("city").getAsString());

        Select select = new Select(state);
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#id_state option"), 1));
        select.selectByValue(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("state").getAsString());

        postcode.sendKeys(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("postcode").getAsString());
        mobilePhoneNumber.sendKeys(JsonReader.readFromJson(USER_INFO_FILE_PATH).get("phoneNumber").getAsString());
        registerButton.click();

        return new WelcomeAccountPage();
    }

}
