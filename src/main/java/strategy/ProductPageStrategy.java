package strategy;

import pages.ProductPage;

public class ProductPageStrategy {

    GoToProductPage goToProduct;

    public void setGoToProductStrategy(GoToProductPage goToProduct) {
        this.goToProduct = goToProduct;
    }

    public ProductPage executeStrategy() {
        return goToProduct.goToProductPage();
    }
}
