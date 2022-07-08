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

    String cartName;
    JsonParser jsonParser;

    @BeforeEach
     void initializeCartNameAndJsonParser(){
        cartName = "UnitTest";
        jsonParser = new JsonParser();
    }

    @ParameterizedTest()
    @ValueSource(strings = {"andrew-cart", "pavel-cart", "alex-cart", "eugen-cart", "viktor-cart"})
    void VerifyFileNameAndFormatAreValid(String name) {
        cartName = name;
        Assertions.assertThrows(NoSuchFileException.class, () -> {
            jsonParser.readFromFile(new File("src/main/resources/" + cartName + ".json"));
        });
    }

    @Disabled
    @Test
    void checkIfNoExceptionDuringWritingData() {
        Cart cart = new Cart(cartName);
        Assertions.assertDoesNotThrow( () -> jsonParser.writeToFile(cart));
    }

    @Test
    void checkIfFileIsCreated() {
        Cart cart = new Cart(cartName);
        jsonParser.writeToFile(cart);
        Assertions.assertTrue(Files.exists(Paths.get("src/main/resources/" + cart.getCartName() + ".json")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"andrew-cart", "eugen-cart"})
    void checkIfReadFileMethodDoesNotReturnNull(String name){
        cartName = name;
        Assertions.assertNotNull(jsonParser.readFromFile(new File("src/main/resources/" + cartName + ".json")));
    }

    @AfterEach
    void deleteCreatedFileAfterTests(){
        try {
            if(cartName.equals("UnitTest")){
                Files.delete(Paths.get("src/main/resources/" + cartName + ".json"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}