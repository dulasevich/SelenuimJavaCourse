package shop;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class VirtualItemTest {

    private VirtualItem virtualItem;

    @BeforeTest
    void initializeVirtualItem() {
        virtualItem = new VirtualItem();
        virtualItem.setName("someItem");
        virtualItem.setPrice(123);
        virtualItem.setSizeOnDisk(11.1);
    }

    @Test
    void testVirtualItem() {
        assertTrue(virtualItem.toString().contains("11.1"));
    }
}