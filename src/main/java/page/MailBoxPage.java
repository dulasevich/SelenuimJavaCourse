package page;

import helper.Waiter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class MailBoxPage extends BasePage{

    @FindBy(xpath = "//a[contains(@class, 'legouser')]/div[contains(@class, 'user-pic')]")
    private WebElement userLogo;

    @FindBy(css = ".legouser__menu-item_action_exit")
    private WebElement logoutButton;

    @FindBy(css = ".ToggleWidget-DayOfMonth")
    private WebElement currentDate;

    public MailBoxPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public WelcomePage logoutFromAccount() {
        Waiter.waifForWebElementVisibility(userLogo);
        userLogo.click();
        logoutButton.click();
        return new WelcomePage();
    }

    public void makeHomePageScreenshot() {
        Waiter.waifForWebElementVisibility(userLogo);
        File savedImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = LocalDateTime.now().toString().replace(':', '-');
        try {
            FileUtils.moveFile(savedImage, new File("C:\\Intel\\" + time + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement getUserLogo() {
        return userLogo;
    }

    public String getCurrentDate() {
        return currentDate.getText();
    }
}
