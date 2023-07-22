package pl.sda.projektPraktyczny;

import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Product;
import pl.sda.projektPraktyczny.services.CategoryService;
import pl.sda.projektPraktyczny.services.ProductService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //TEST
        //TEST
        //TEST

        Category category1 = new Category("Jedzenie");
        Category category2 = new Category("Napoje");
        Category category3 = new Category("Higiena");
        System.out.println(CategoryService.categories);

        Product product1 = new Product(2.50, "Chleb", category1, 2);
        Product product2 = new Product(5.0, "Sok", category2, 1);
        Product product3 = new Product(10.0, "Szampon", category3, 5);


        ProductService.addProduct(product1);
        ProductService.addProduct(product2);
        ProductService.addProduct(product3);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        System.out.println("-------------------------------------");
        ProductService productService = new ProductService();
        productService.showProductById(3);
    }
}