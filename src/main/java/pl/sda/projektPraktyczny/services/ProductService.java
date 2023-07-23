package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Product;

import java.util.ArrayList;
import java.util.List;

public final class ProductService {

    private List<Product> products = new ArrayList<>();


    public void addProduct(Product productToAdd) {
        products.add(productToAdd);
        System.out.println("Produkt " + productToAdd.getName() + " został dodany");
    }


    public void removeProduct(Product productToRemove) {
        products.remove(productToRemove);
        System.out.println("Produkt " + productToRemove.getName() + " został usunięty");
    }


    public void showAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void showProductById(int productId) {
        for (Product productItem : products) {
            if (productItem.getProductId() == productId) {
                System.out.println(productItem);
            }
        }
    }

}