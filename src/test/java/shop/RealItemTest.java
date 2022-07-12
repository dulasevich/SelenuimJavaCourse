package shop;

import org.junit.jupiter.api.*;

class RealItemTest {

    private RealItem realItem;
    private static final String EXPECTED_RESULT = "Class: class shop.RealItem; Name: someItem; Price: 101.5; Weight: 1560.55";

    @BeforeEach
    void initializeRealItem() {
        realItem = new RealItem();
        realItem.setName("someItem");
        realItem.setWeight(1560.55);
        realItem.setPrice(101.5);
    }

    @Test
    void testRealItem() {
        Assertions.assertEquals(EXPECTED_RESULT, realItem.toString());
    }
}
