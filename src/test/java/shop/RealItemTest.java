package shop;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RealItemTest {

    private RealItem realItem;
    private static final String EXPECTED_RESULT = "Class: class shop.RealItem; Name: someItem; Price: 101.5; Weight: 1560.55";

    @BeforeTest
    void initializeRealItem() {
        realItem = new RealItem();
        realItem.setName("someItem");
        realItem.setWeight(1560.55);
        realItem.setPrice(101.5);
    }

    @Test
    void testRealItem() {
        assertEquals(EXPECTED_RESULT, realItem.toString());
    }
}
