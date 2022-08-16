import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

import static by.Variables.USA_STATES;

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

    private List<String> randomThreeStatesSelection(Select select) {
        Random random = new Random();
        List<WebElement> allStates = select.getOptions();
        Set<String> expectedStates = new HashSet<>();
        int numberOfOptionsToBeSelected=3;
        while (expectedStates.size() != numberOfOptionsToBeSelected) {
            for (int i = 0; i < numberOfOptionsToBeSelected; i++) {
                int randomIndex = random.nextInt(allStates.size());
                expectedStates.add(allStates.get(randomIndex).getText());
            }
        }
        return new ArrayList<>(expectedStates);
    }

    @Test
    void multiTest() {
        WebElement multi = driver.findElement(USA_STATES);
        Select select = new Select(multi);
        List<String> expected = randomThreeStatesSelection(select);
        for(String state : expected){
            select.selectByVisibleText(state);
        }
        List<String> selectedOptions = select.getAllSelectedOptions().stream()
                .map(WebElement::getText).collect(Collectors.toList());
        Collections.sort(expected);
        Collections.sort(selectedOptions);
        Assertions.assertTrue(expected.equals(selectedOptions));
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
