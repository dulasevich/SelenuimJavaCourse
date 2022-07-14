package parser;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class JsonParserTest {

    private final static String EXPECTED_RESULT = "{\"cartName\":\"Test\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";
    private JsonParser jsonParser;
    private Cart cart;

    @BeforeTest (groups = {"checkinTests"})
    void initializeCart() {
        jsonParser = new JsonParser();
        cart = new Cart("Test");
    }

    @DataProvider(name = "fileName")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"andrew-cart"}, {"pavel-cart"}, {"alex-cart"}, {"eugen-cart"}, {"viktor-cart"}};
    }


    @Test(dataProvider = "fileName")
    public void testNoSuchFileException(String data) {
        assertThrows(NoSuchFileException.class, () -> {
            jsonParser.readFromFile(new File("src/main/resources/" + data + ".json"));
        });
    }

    @Parameters({"name"})
    @Test
    public void testNoSuchFileExceptionParameter(String name) {
        assertThrows(NoSuchFileException.class, () -> {
            jsonParser.readFromFile(new File("src/main/resources/" + name + ".json"));
        });
    }

    @Test
    void testWriteToFile() throws IOException {
        jsonParser.writeToFile(cart);
        String actualResult = Files.readString(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
        assertEquals(EXPECTED_RESULT, actualResult);
    }

    @Test (groups = {"checkinTests"})
    void testReadFromFile() {
        Cart actualResult = jsonParser.readFromFile(new File("src/main/resources/andrew-cart.json"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("andrew-cart", actualResult.getCartName());
        softAssert.assertEquals(38445.479999999996, actualResult.getTotalPrice());
        softAssert.assertAll();
    }

    @AfterTest
    void deleteCreatedFile() {
        try {
            if (cart.getCartName().equals("Test")) {
                Files.delete(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
            }
        } catch (Exception ignored) {

        }
    }
}