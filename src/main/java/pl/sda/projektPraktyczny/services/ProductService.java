package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Order;
import pl.sda.projektPraktyczny.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static List<Product> products = new ArrayList<>();

    public List<Product> generateProductsList() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produkt został dodany");
    }

    public void removeProduct (Product product) {
        products.remove(product);
        System.out.println("Produkt został usunięty");
    }


    public void showAllProducts() {
        boolean found = false;
        for (Product product : products) {
            System.out.println(product);
            found = true;
        }
        if (!found){
            System.out.println("Nie ma żadnych produktów");
        }
    }

    public Product showProductByProductId(Product product) {
        for (Product productItem : products) {
            if (product.getProductId().equals(product)) {
                return product;
            }
        }
        System.out.println("Nie ma takiego zamówienia");
        return null;
    }


}
