package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadPage extends BasePage{

    @FindBy(linkText = "sample.txt")
    private WebElement downloadElement;

    public DownloadPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void download() {
        downloadElement.click();
    }
}
