package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest{

    private final static String CART_PRODUCTS_NUMBER = "3 Products";
    private CartPage cartPage;

    @Description("Test case verifies the ability to add to cart")
    @TmsLink("AP5")
    @Test
    void cartProductNumberTest() {
        homePage.addProductByPosition(0);
        homePage.addProductByPosition(2);
        homePage.addProductByPosition(6);
        cartPage = homePage.goToCart();
        assertEquals(cartPage.getCartProductsQuantity(), CART_PRODUCTS_NUMBER);
    }

    @AfterClass
    void cleanProducts() {
        cartPage.cleanProducts();
    }

}
