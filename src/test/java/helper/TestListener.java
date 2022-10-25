package helper;

import driver.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Allure.addAttachment(
                    result.getName(),
                    new FileInputStream(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Capabilities caps = ((RemoteWebDriver) Driver.getDriver()).getCapabilities();
        Allure.parameter("time", LocalDateTime.now());
        Allure.parameter(caps.getBrowserName(), caps.getBrowserVersion());
        Allure.parameter("platform", caps.getPlatformName());
    }
}


