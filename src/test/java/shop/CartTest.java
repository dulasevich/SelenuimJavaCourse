package shop;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest {

    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeTest
    void initializeCart() {
        cart = new Cart("UnitTestCart");
        realItem = new RealItem();
        virtualItem = new VirtualItem();

        realItem.setPrice(10);
        virtualItem.setPrice(10);

        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);
    }

    @Test
    void testGetTotalPrice() {
        assertEquals(24, cart.getTotalPrice());
    }

    @Test(groups = {"brokenTest"})
    void testGetTotalPriceAfterDeletion() {
        cart.deleteRealItem(realItem);
        assertEquals(12, cart.getTotalPrice());
    }
}