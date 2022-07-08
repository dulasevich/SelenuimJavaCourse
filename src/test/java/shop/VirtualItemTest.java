package shop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VirtualItemTest {

    @BeforeEach
    void showTestStart(){
        System.out.println("Test starts");
    }

    @Test
    void SizeOnDiskIsNotZeroOnceSet() {
        System.out.println("===========");
        System.out.println("Test runs");
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setSizeOnDisk(11.1);
        Assertions.assertFalse(virtualItem.getSizeOnDisk() == 0.0);
    }

    @AfterEach
    void showTestEnd(){
        System.out.println("===========");
        System.out.println("Test ends");
    }

}