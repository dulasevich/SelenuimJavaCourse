package tests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.accountPages.WelcomeAccountPage;
import pages.accountPages.WishListPage;

import static helper.AllureTestName.setTestName;
import static org.testng.Assert.*;

//@Listeners(TestListener.class) - does not work for some reason, should be only here?
public class AutoCreatedWishListTests extends BaseTest{

    private final static String LOGIN = "dulasev@mail.ru";
    private final static String PASSWORD = "qaz123";
    private WishListPage wishListPage;

    @BeforeClass
    private void setName() {
        setTestName("AP-3");
    }

    @Description("Test verifies there is no WishList created in the account")
    @Test(priority = 1)
    void checkNoWishListExist() {
        setTestName("Pre-condition for AP3");
        LoginPage loginPage = homePage.navigateToLoginScreen();
        WelcomeAccountPage welcomePage = loginPage.login(LOGIN, PASSWORD);
        wishListPage = welcomePage.navigateToWishList();
        assertFalse(wishListPage.checkIfWishListExists());
    }

    @Description("Test case verifies WishList is created automatically and correct product is added to that")
    @Test(priority = 2)
    void autoCreateWishListTest() {
        setTestName("AP-3");
        ProductPage productPage = wishListPage.goToProductPage();
        String productName = productPage.getProductName();
        productPage.addProductToWishList();
        WelcomeAccountPage welcomePage = productPage.goToAccount();
        wishListPage = welcomePage.navigateToWishList();
        wishListPage.viewWishList();
        assertTrue(wishListPage.getWishListProductName().trim().contains(productName));
    }

    @AfterClass()
    void cleanWishList() {
        wishListPage.DeleteWishList();
    }
}
