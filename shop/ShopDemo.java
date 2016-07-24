import models.Buyer;
import models.Shop;
import products.Product;
import products.ProductByAmount;
import products.ProductByKilogram;

/**
 * Created by Parapanov on 21/07/2016.
 */
public abstract class ShopDemo {

    public static void main(String[] args) {
        Shop shop = new Shop("Kvartlnia", "Mladost", 10);
        //Месо, Сирене, Риба
        ProductByKilogram productKg1 = new ProductByKilogram("Meat", 5.5, 5);
        ProductByKilogram productKg2 = new ProductByKilogram("Cheese", 2, 10);
        ProductByKilogram productKg3 = new ProductByKilogram("Fish", 8, 4);

        ProductByAmount productAt1 = new ProductByAmount("Beer", 10.0, 1);
        ProductByAmount productAt2 = new ProductByAmount("Seat", 20, 2);
        ProductByAmount productAt3 = new ProductByAmount("Book", 10, 10);

        addProductsToShop(shop, productAt1, productAt2, productAt3, productKg1, productKg2, productKg3);

        Buyer pesho = new Buyer(shop, 30.50, 10);
        Buyer gosho = new Buyer(shop, 10.90, 5);
        Buyer tosho = new Buyer(shop, 100.10, 20);
        Buyer rich = new Buyer(shop, 1000000, 100);

        shop.showShopStocks();

        tryAddProduct(gosho, "Cheese", 1);
        tryAddProduct(gosho, "Cheese", 1);
        tryAddProduct(gosho, "Cheese", 1);
        tryAddProduct(gosho, "Cheese", 1);
        tryAddProduct(gosho, "Cheese", 1);
        tryAddProduct(gosho, "Cheese", 1);

        tryAddProduct(gosho, "Meat", 3);

        tryRemoveProduct(pesho, "Beer");
        tryRemoveProduct(gosho, "Beer");

        tryAddProduct(pesho, "Beer", 2);
        tryAddProduct(tosho, "Makaroni", 99);
        tryAddProduct(tosho, "Seat", 1);
        tryAddProduct(tosho, "Seat", 1);
        tryAddProduct(tosho, "Cheese", 5);
        tryAddProduct(rich, "Meat", 2);
        tryAddProduct(rich, "Book", 10);

        tryRemoveProduct(tosho, "Makaroni");

        tryAddProduct(tosho, "Book", 100);
        tryAddProduct(tosho, "Meat", 3);
        tryAddProduct(rich, "Fish", 4);

        tryPayForProducts(gosho);
        tryPayForProducts(pesho);
        tryPayForProducts(rich);

        shop.showShopStocks();

    }

    private static void tryPayForProducts(Buyer buyer) {
        try {
            buyer.payForProducts();

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (UnsupportedOperationException uoe) {
            System.out.println(uoe.getMessage());
        }
    }

    private static void tryRemoveProduct(Buyer buyer, String productName) {
        try {
            buyer.removeProductFromBasket(productName);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (UnsupportedOperationException uoe) {
            System.out.println(uoe.getMessage());
        }
    }

    private static void tryAddProduct(Buyer buyer, String productName, int amount) {
        try {
            buyer.addProductInBasket(productName, amount);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (UnsupportedOperationException uoe) {
            System.out.println(uoe.getMessage());
        }

    }

    private static void addProductsToShop(Shop shop, Product... products) {
        shop.addProducts(products);
    }
}