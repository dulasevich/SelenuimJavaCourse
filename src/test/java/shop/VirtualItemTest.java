package shop;

import org.junit.jupiter.api.*;

class VirtualItemTest {

    private VirtualItem virtualItem;
    private static final String EXPECTED_RESULT = "Class: class shop.VirtualItem; Name: someItem; Price: 123.0; Size on disk: 11.1";

    @BeforeEach
    void initialiazeVirtualItem() {
        virtualItem = new VirtualItem();
        virtualItem.setName("someItem");
        virtualItem.setPrice(123);
        virtualItem.setSizeOnDisk(11.1);
    }

    @Test
    void testVirtualItem() {
        Assertions.assertTrue(EXPECTED_RESULT.equals(virtualItem.toString()));
    }
}