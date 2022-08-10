import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static by.Variables.states;

//Сovers task 5
public class MultiSelectTest {

    private WebDriver driver;

    @BeforeEach
    void initializeDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    @Test
    void multiTest() {
        WebElement multi = driver.findElement(states);
        Select select = new Select(multi);

        List<String> allOptions = select.getOptions().stream().map(el -> el.getText()).collect(Collectors.toList());

        Random r = new Random();
        while (select.getAllSelectedOptions().size() != 3) {
            select.selectByIndex(r.nextInt(select.getOptions().size() - 1));
        }
        List<WebElement> selected = select.getAllSelectedOptions();
        List<String> selectedOptions = new ArrayList<>();
        selected.forEach(el -> selectedOptions.add(el.getText()));

        Assertions.assertTrue(allOptions.containsAll(selectedOptions));
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
