package helper;

import driver.Driver;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestFailure implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws FileNotFoundException {
        if(context.getExecutionException().isPresent()) {
            Allure.addAttachment(
                    context.getDisplayName(),
                    new FileInputStream(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE)));
            Capabilities caps = ((RemoteWebDriver) Driver.getDriver()).getCapabilities();
            Allure.parameter(caps.getBrowserName(), caps.getBrowserVersion());
        }
    }
}
