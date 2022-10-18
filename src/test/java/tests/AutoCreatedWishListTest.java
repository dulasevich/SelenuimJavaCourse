package tests;

import driver.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.accountPages.WelcomeAccountPage;
import pages.accountPages.WishListPage;

import static org.testng.Assert.assertTrue;

//@Listeners(TestListener.class) - does not work for some reason, should be only here?
public class AutoCreatedWishListTest extends BaseTest{

    private final static String LOGIN = "dulasev@mail.ru";
    private final static String PASSWORD = "qaz123";
    private WishListPage wishListPage;

    @BeforeMethod
    private void checkNoWishListExist() {
        LoginPage loginPage = homePage.navigateToHeader().goToLoginScreen();
        WelcomeAccountPage welcomePage = loginPage.login(LOGIN, PASSWORD);
        wishListPage = welcomePage.goToWishList();
        if (wishListPage.checkIfWishListExists()) {
            Driver.turnDriverDown();
            throw new SkipException("Skipping test because wishlist exists");
        }
    }

    @Description("Test case verifies WishList is created automatically and correct product is added to that")
    @TmsLink("AP3")
    @Test()
    void autoCreateWishListTest() {
        ProductPage productPage = wishListPage.goToProductPage();
        String productName = productPage.getProductName();
        productPage.addProductToWishList();
        WelcomeAccountPage welcomePage = productPage.navigateToHeader().goToAccount();
        wishListPage = welcomePage.goToWishList();
        wishListPage.viewWishList();
        assertTrue(wishListPage.getWishListProductName().trim().contains(productName));
    }

    @AfterClass
    void cleanWishList() {
        wishListPage.DeleteWishList();
    }
}
