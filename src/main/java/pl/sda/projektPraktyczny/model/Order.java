package pl.sda.projektPraktyczny.model;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Order {
    private static int lastId = 0;
    private final int orderID;
    private final String orderNumber;
    private double orderSum;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private Enum orderStatus;
    private Map<Product, Integer> products;
    Random random = new Random();

    public Order(double orderSum, String clientName, String clientSurname, String clientAddress, Enum orderStatus, Map<Product, Integer> products) {
        this.orderID = ++lastId;
        this.orderNumber = String.valueOf(99999999 - random.nextInt(99999999));
        if (isValidOrderSum(orderSum)) {
            this.orderSum = orderSum;
        } else {
            throw new IllegalArgumentException("Błędna suma zamówienia!");
        }
        if (isValidName(clientName)) {
            this.clientName = clientName;
        } else {
            throw new IllegalArgumentException("Błędne imię!");
        }
        if (isValidName(clientSurname)) {
            this.clientSurname = clientSurname;
        } else {
            throw new IllegalArgumentException("Błędne nazwisko!");
        }
        if (isValidAdress(clientAddress)) {
            this.clientAddress = clientAddress;
        } else {
            throw new IllegalArgumentException("Błędny adres!");
        }
        this.orderStatus = orderStatus;
        if (isValidProducts(products)) {
            this.products = products;
        } else {
            throw new IllegalArgumentException("Pusty koszyk!");
        }
    }

    private boolean isValidOrderSum(double sum){
        return sum > 0;
    }
    private boolean isValidName(String name) {
        return name != null && !name.isBlank() && name.length() > 0 && name.length() < 50 && name.matches("\\w+\\.?");
    }
    private boolean isValidAdress(String name) {
        return name != null && !name.isBlank() && name.length() > 0 && name.length() < 50;
    }
    private boolean isValidProducts(Map<Product, Integer> products) {
        return !products.values().isEmpty();
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        if (isValidOrderSum(orderSum)) {
            this.orderSum = orderSum;
        } else {
            throw new IllegalArgumentException("Błędna suma zamówienia!");
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        if (isValidName(clientName)) {
            this.clientName = clientName;
        } else {
            throw new IllegalArgumentException("Błędne imię!");
        }
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        if (isValidName(clientSurname)) {
            this.clientSurname = clientSurname;
        } else {
            throw new IllegalArgumentException("Błędne nazwisko!");
        }
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        if (isValidAdress(clientAddress)) {
            this.clientAddress = clientAddress;
        } else {
            throw new IllegalArgumentException("Błędny adres!");
        }
    }

    public Enum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Enum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        if (isValidProducts(products)) {
            this.products = products;
        } else {
            throw new IllegalArgumentException("Pusty koszyk!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Double.compare(order.orderSum, orderSum) == 0 && Objects.equals(orderNumber, order.orderNumber) && Objects.equals(clientName, order.clientName) && Objects.equals(clientSurname, order.clientSurname) && Objects.equals(clientAddress, order.clientAddress) && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderNumber, orderSum, clientName, clientSurname, clientAddress, orderStatus, products);
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", orderNumber='" + orderNumber + '\'' + ", orderSum=" + orderSum + ", clientName='" + clientName + '\'' + ", clientSurname='" + clientSurname + '\'' + ", clientAddress='" + clientAddress + '\'' + ", orderStatus=" + orderStatus + ", products=" + products + '}';
    }
}
