package pl.sda.projektPraktyczny.models;

import java.util.Objects;

public class Product {

    private final int productId;
    private static int lastProductId = 0;
    private final double price;
    private final String name;
    private final Category category;
    private final int quantity;

    public Product(double price, String name, Category category, int quantity) {
        this.productId = ++lastProductId;

        if (!isValidPrice(price)) {
            throw new IllegalArgumentException("Cena musi być większa od zera!");
        }
        this.price = price;

       if (!isValidName(name)) {
           throw new IllegalArgumentException("Nazwa nie może być pusta oraz nazwa może mieć max 50 znaków!");
       } this.name = name;

        if (!isValidCategory(category)) {
            throw new IllegalArgumentException("Kategoria nie może być pusta!");
        }
        this.category = category;

        if (!isValidQuantity(quantity)) {
            throw new IllegalArgumentException("Ilość nie może wynosić zero!");
        }
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }



    private boolean isValidPrice(double price) {
        return price > 0;
    }

    private boolean isValidCategory(Category category) {
        return category != null;
    }

    private boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    private boolean isValidName(String name) {
        return name != null && !name.isBlank() && name.length() > 0 && name.length() < 50;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getProductId() == product.getProductId() && Double.compare(product.getPrice(), getPrice()) == 0 && getQuantity() == product.getQuantity() && Objects.equals(getName(), product.getName()) && Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getPrice(), getName(), getCategory(), getQuantity());
    }
}
