package pages;

import dto.User;
import helper.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.accountPages.WelcomeAccountPage;

import java.util.List;

public class CreateAccountPage extends BasePage{

    @FindBy(xpath = ".//*[@id='id_state']/option")
    private List<WebElement> stateOptions;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(css = "#passwd")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='address1']")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(css = "#id_state")
    private WebElement stateField;

    @FindBy(id = "postcode")
    private WebElement postcodeField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneNumberField;

    public CreateAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Add personal information to register account")
    public WelcomeAccountPage registerAccount(User user) {
        Waiter.waifForWebElementVisibility(firstNameField);

        firstNameField.sendKeys(user.getFirstname());
        lastNameField.sendKeys(user.getLastname());
        passwordField.sendKeys(user.getPass());
        addressField.sendKeys(user.getAddress());
        cityField.sendKeys(user.getCity());

        Select select = new Select(stateField);
        Waiter.waifForNumberOfElementsToBe(stateOptions, 54);
        select.selectByValue(user.getState());

        postcodeField.sendKeys(user.getPostcode());
        mobilePhoneNumberField.sendKeys(user.getPhoneNumber());

        registerButton.click();
        return new WelcomeAccountPage();
    }

}
