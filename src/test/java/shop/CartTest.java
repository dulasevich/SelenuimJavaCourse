package shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {

    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeEach
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
        Assertions.assertEquals(24, cart.getTotalPrice());
    }

    @Test
    void testGetTotalPriceAfterDeletion() {
        cart.deleteRealItem(realItem);
        Assertions.assertEquals(12, cart.getTotalPrice());
    }
}