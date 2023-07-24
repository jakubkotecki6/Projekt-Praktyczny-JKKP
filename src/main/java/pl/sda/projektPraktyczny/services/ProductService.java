package pl.sda.projektPraktyczny.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Product;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ProductService {

    private static List<Product> products = new ArrayList<>();


    public static void generateProductsList() {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("ProductsDB.JSON")) {
            gson.toJson(products, writer);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania listy zamówień " + e.getMessage());
        }
    }

    public void loadProductsFromFile() {
        try (Reader reader = new FileReader("ProductsDB.JSON")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<ArrayList<Product>>(){}.getType();
            products = gson.fromJson(reader, type);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytywania listy zamówień " + e.getMessage());
        }
    }

    public List<Product> getProducts() {
        return products;
    }

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