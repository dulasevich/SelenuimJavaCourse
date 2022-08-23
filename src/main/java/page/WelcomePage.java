package page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class WelcomePage extends BasePage{

    @FindBy(linkText = "Log in")
    private WebElement loginButton;

    public WelcomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public LoginPage navigateToLoginScreen() {
        loginButton.click();
        return new LoginPage();
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void makeHomePageScreenshot() {
        File savedImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = LocalDateTime.now().toString().replace(':', '-');
        try {
            FileUtils.moveFile(savedImage, new File("C:\\Intel\\" + time + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}