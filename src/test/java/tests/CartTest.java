package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.*;
import pages.accountPages.WelcomeAccountPage;
import pages.accountPages.WishListPage;
import strategy.ProductPageStrategy;

import static helper.AllureTestName.setTestName;
import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest{

    private final static String LOGIN = "dulasev@mail.ru";
    private final static String PASSWORD = "qaz123";
    private final static String CART_PRODUCTS_NUMBER = "3 Products";
    private CartPage cartPage;
    ProductPageStrategy productPageStrategy = new ProductPageStrategy();

    @Description("Test case verifies the ability to add to cart")
    @Test
    void cartProductNumberTest() {
        setTestName("AP-5");
        productPageStrategy.setGoToProductStrategy(homePage);
        ProductPage productPage = productPageStrategy.executeStrategy();
        productPage.addProductToCart();
        IndexPage indexPage = productPage.goToIndexPage();
        productPageStrategy.setGoToProductStrategy(indexPage);
        productPage = productPageStrategy.executeStrategy();
        productPage.addProductToCart();
        LoginPage loginPage = productPage.navigateToLoginScreen();
        WelcomeAccountPage welcomeAccountPage = loginPage.login(LOGIN, PASSWORD);
        WishListPage wishListPage = welcomeAccountPage.navigateToWishList();
        productPageStrategy.setGoToProductStrategy(wishListPage);
        productPageStrategy.executeStrategy();
        productPage.addProductToCart();
        cartPage= productPage.navigateToCart();
        assertEquals(cartPage.getCartProductsNumber(), CART_PRODUCTS_NUMBER);
    }

    @AfterClass
    void cleanProducts() {
        cartPage.cleanProducts();
    }

}
