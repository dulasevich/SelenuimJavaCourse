import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import table.User;

import java.util.ArrayList;
import java.util.List;

import static by.Variables.*;

//covers task 9
public class TableUserTest {

    private WebDriver driver;

    @BeforeEach
    void initializeBrowser() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
    }

    private List<User> filterUsers(int minAge, int maxSalary) {
        List<User> users = new ArrayList<>();
        do{
            WebElement nextButton = driver.findElement(NEXT_PAGE_ICON);
            collectUsers(users, minAge, maxSalary);
            nextButton.click();
        } while (driver.findElement(NEXT_PAGE_ICON).getAttribute("class").equals("paginate_button next"));
        return users;
    }

    private void collectUsers(List<User> users, int minAge, int maxSalary) {
        List<WebElement> rows = driver.findElements(TABLE_ROWS);
        rows.forEach( row -> {
            int salary = Integer.parseInt(row.findElement(TABLE_SALARY).getAttribute("data-order"));
            int age = Integer.parseInt(row.findElement(TABLE_AGE).getText());
            if( salary <= maxSalary && age > minAge){
                String name = row.findElement(TABLE_NAME).getText();
                String position = row.findElement(TABLE_POSITION).getText();
                String office = row.findElement(TABLE_OFFICE).getText();
                users.add(new User(name, position, office));
            }
        });
    }

    @Test()
    void testFilter() {
        WebElement sortOption = driver.findElement(ITEMS_PER_PAGE);
        Select select = new Select(sortOption);
        select.selectByValue("10");
        List<User> users = filterUsers(40, 92575);
        Assertions.assertEquals(2, users.size());
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }
}
