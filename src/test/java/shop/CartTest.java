package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {

    Cart cart;
    RealItem realItem;
    VirtualItem virtualItem;

    @BeforeEach
    void createCart(){
        cart = new Cart("UnitTestCart");
        realItem = new RealItem();
        virtualItem = new VirtualItem();
    }

    @Test
    void verifyCartNameEqualsSet(){
        Assertions.assertEquals("UnitTestCart", cart.getCartName());
    }

    @Test
    void checkCartTotalPrice(){
        realItem.setPrice(10);
        virtualItem.setPrice(10);

        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);

        Assertions.assertEquals(realItem.getPrice() * 1.2 + virtualItem.getPrice() * 1.2, cart.getTotalPrice());
    }

    @AfterEach
    void clearCart(){
        cart.deleteVirtualItem(virtualItem);
        cart.deleteRealItem(realItem);
    }
}