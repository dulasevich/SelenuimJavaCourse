package parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class JsonParserTest {

    private final static String EXPECTED_RESULT = "{\"cartName\":\"Test\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";
    private JsonParser jsonParser;
    private Cart cart;

    @BeforeEach
    void initializeCart() {
        jsonParser = new JsonParser();
        cart = new Cart("Test");
    }

    @ParameterizedTest()
    @ValueSource(strings = {"andrew-cart", "pavel-cart", "alex-cart", "eugen-cart", "viktor-cart"})
    void testNoSuchFileException(String name) {
        Assertions.assertThrows(NoSuchFileException.class, () -> {
            jsonParser.readFromFile(new File("src/main/resources/" + name + ".json"));
        });
    }

    @Disabled
    @Test
    void testWriteToFile() throws IOException {
        jsonParser.writeToFile(cart);
        String actualResult = Files.readString(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
        Assertions.assertEquals(EXPECTED_RESULT, actualResult);
    }

    @Test
    void testReadFromFile() {
        Cart actualResult = jsonParser.readFromFile(new File("src/main/resources/andrew-cart.json"));
        Assertions.assertAll(
                () -> Assertions.assertEquals("andrew-cart", actualResult.getCartName()),
                () -> Assertions.assertEquals(38445.479999999996, actualResult.getTotalPrice())
        );
    }

    @AfterEach
    void deleteCreatedFile() {
        try {
            if (cart.getCartName().equals("Test")) {
                Files.delete(Paths.get("src/main/resources/" + cart.getCartName() + ".json"));
            }
        } catch (Exception ignored) {

        }
    }
}