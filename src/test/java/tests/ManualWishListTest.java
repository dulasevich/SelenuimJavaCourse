package tests;

import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.accountPages.WelcomeAccountPage;
import pages.accountPages.WishListPage;

import static helper.AllureTestName.setTestName;
import static org.testng.Assert.assertTrue;

//@Listeners(TestListener.class) - does not work for some reason, should be only here?
public class ManualWishListTest extends BaseTest{

    private final static String LOGIN = "dulasev@mail.ru";
    private final static String PASSWORD = "qaz123";
    private final static String WISH_LIST_NAME = RandomStringUtils.randomAlphabetic(10);
    private WishListPage wishListPage;

    @Description("Test case Verifies the ability to add product to your Wishlist")
    @Test
    void createWishListTest() {
        setTestName("AP-4");
        LoginPage loginPage = homePage.navigateToLoginScreen();
        WelcomeAccountPage welcomePage = loginPage.login(LOGIN, PASSWORD);
        wishListPage = welcomePage.navigateToWishList();
        wishListPage.createWishList(WISH_LIST_NAME);
        ProductPage productPage = wishListPage.goToProductPage();
        String productName = productPage.getProductName();
        productPage.addProductToWishList();
        welcomePage = productPage.goToAccount();
        wishListPage = welcomePage.navigateToWishList();
        wishListPage.viewWishList();
        assertTrue(wishListPage.getWishListProductName().contains(productName));
    }

    @AfterClass()
    void cleanWishList() {
        wishListPage.DeleteWishList();
    }
}
