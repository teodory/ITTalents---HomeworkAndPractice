package ShopingCenters;

import Dealers.Product;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class Wharehouse {

    public static Product[] concatProducts(Product[] products, Product[] products1) {
        products = clearEmptyElements(products);
        products1 = clearEmptyElements(products1);

        Product[] newProducts = new Product[products.length + products1.length];
        int index = 0;

        for (Product product : products) {
            newProducts[index++] = product;
        }
        for (Product product : products1) {
            newProducts[index++] = product;
        }

        return newProducts;
    }

    public static Product[] clearEmptyElements(Product[] products) {

        int productsCount = 0;
        for (Product product : products) {
            if (product != null) {
                productsCount++;
            }
        }

        Product[] cleanedProducts = new Product[productsCount];
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                cleanedProducts[index++] = products[i];
            }
        }

        return cleanedProducts;
    }
}
