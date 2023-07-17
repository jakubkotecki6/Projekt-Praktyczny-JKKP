package pl.sda.projektPraktyczny.model;

public class Product {

    private int productId;
    private static int lastId = 0;
    private double price;
    private String name;
    private Category category;
    private int quantity;

    public Product(int productId, double price, String name, Category category, int quantity) {
        this.productId = ++lastId;

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

    public void setPrice(double price) {
            this.price = price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
