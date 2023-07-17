package pl.sda.projektPraktyczny.model;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Order {
    private static int counter = 0;
    private int orderID;
    private String orderNumber;
    private double orderSum;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private Enum orderStatus;
    private Map<Product, Integer> products;
    Random random = new Random();

    public Order(double orderSum, String clientName, String clientSurname, String clientAddress, Enum orderStatus, Map<Product, Integer> products) {
        this.orderID = ++counter;
        this.orderNumber = String.valueOf(99999999 - random.nextInt(99999999));
        if (orderSum > 0) {
            this.orderSum = orderSum;
        }
        if (clientName != null && !clientName.isBlank() && clientName.length() > 0 && clientName.length() < 50 && clientName.matches("\\w+\\.?")){
            this.clientName = clientName;
        }
        if (clientSurname != null && !clientSurname.isBlank() && clientName.length() > 0 && clientName.length() < 50) {
            this.clientSurname = clientSurname;
        }
        if (clientAddress != null && !clientAddress.isBlank() && clientName.length() > 0 && clientName.length() < 50) {
            this.clientAddress = clientAddress;
        }
        this.orderStatus = orderStatus;
        if (!products.values().isEmpty()) {
            this.products = products;
        }
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
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
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID
                && Double.compare(order.orderSum, orderSum) == 0
                && Objects.equals(orderNumber, order.orderNumber)
                && Objects.equals(clientName, order.clientName)
                && Objects.equals(clientSurname, order.clientSurname)
                && Objects.equals(clientAddress, order.clientAddress)
                && Objects.equals(orderStatus, order.orderStatus)
                && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderNumber, orderSum, clientName, clientSurname, clientAddress, orderStatus, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderSum=" + orderSum +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", orderStatus=" + orderStatus +
                ", products=" + products +
                '}';
    }
}
