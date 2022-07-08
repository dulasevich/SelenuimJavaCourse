package shop;

import org.junit.jupiter.api.*;

class RealItemTest {

    @BeforeEach
    void showTestStart(){
        System.out.println("Test starts");
    }

    @Test
    void WeightOfRealItemMatchesSetValue() {
        System.out.println("===========");
        System.out.println("Test runs");
        RealItem realItem = new RealItem();
        realItem.setName("someItem");
        realItem.setWeight(1560.55);
        realItem.setPrice(101.5);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(realItem.getName()),
                () -> Assertions.assertEquals(1560.55, realItem.getWeight()),
                () -> Assertions.assertEquals(101.50, realItem.getPrice())
        );
    }

    @AfterEach
    void showTestEnd(){
        System.out.println("===========");
        System.out.println("Test ends");
    }

}