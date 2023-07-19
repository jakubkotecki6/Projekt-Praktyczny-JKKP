package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static List<Product> products = new ArrayList<>();

    public List<Product> generateProductsList() {
        return products;
    }

    public static void addProduct(List<Product> products, Product newProduct) {
        products.add(newProduct);
        System.out.println("Produkt został dodany");
    }

    public void removeProduct (List<Product> products, Product productToRemove) {
        products.remove(productToRemove);
        System.out.println("Produkt został usunięty");
    }


    public void showAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
