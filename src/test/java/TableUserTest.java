import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import table.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static by.Variables.*;

//covers task 9
public class TableUserTest {

    private WebDriver driver;
    private int usersNumber;

    @BeforeEach
    void initializeBrowser() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
    }

    private List<User> filterUsers() {
        List<WebElement> names = driver.findElements(userName);
        List<String> name = names.stream().map( uName -> uName.getText()).collect(Collectors.toList());

        List<WebElement> positions = driver.findElements(userPosition);
        List<String> position = new ArrayList<>();
        positions.forEach(userPosition -> position.add(userPosition.getText()));

        List<WebElement> offices = driver.findElements(userOffice);
        List<String> office = new ArrayList<>();
        offices.forEach(userOffice -> office.add(userOffice.getText()));

        List<WebElement> ages = driver.findElements(userAge);
        List<Integer> age = ages.stream().mapToInt(aage -> Integer.parseInt(aage.getText())).boxed().collect(Collectors.toList());

        List<WebElement> salaries = driver.findElements(userSalary);
        List<Integer> salary = new ArrayList<>();
        salaries.forEach(userSalary -> salary.add(Integer.parseInt(userSalary.getAttribute("data-order"))));

        List<User> users = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            users.add(new User(name.get(i), position.get(i), office.get(i), age.get(i), salary.get(i)));
        }

        return users.stream().filter(user -> user.getAge() > 40 && user.getSalary() <= 92575).collect(Collectors.toList());
    }

    @Test()
    void testFilter() {
        WebElement sortOption = driver.findElement(sort);
        Select select = new Select(sortOption);
        Assumptions.assumeTrue(select.getFirstSelectedOption().getText().equals("10"));

        usersNumber = filterUsers().size();

        WebElement secondPage = driver.findElement(pageTwo);
        secondPage.click();
        usersNumber += filterUsers().size();

        WebElement thirdPage = driver.findElement(pageThree);
        thirdPage.click();
        usersNumber += filterUsers().size();

        WebElement forthPage = driver.findElement(pageFour);
        forthPage.click();
        usersNumber += filterUsers().size();

        Assertions.assertEquals(2, usersNumber);
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
