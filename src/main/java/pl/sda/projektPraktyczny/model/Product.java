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
        this.price = price;
        this.name = name;
        this.category = category;
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
        if (isValidPrice(price)) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Cena musi być większa od zera.");
        }
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

    private boolean isValidName(String name) {
        return name != null && !name.isBlank();
    }
}
