package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Order;
import pl.sda.projektPraktyczny.models.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderService {


    List<Order> orders = new ArrayList<>();

    public List<Order> generateOrdersList() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Zamówienie zostało dodane");
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        System.out.println("Zamówienie zostało usunięte");
    }

    public void removeOrderByOrderNumber(int orderNumber) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderNumber().equals(orderNumber)) {
                orders.remove(orderNumber);
                found = true;
                System.out.println("Zamówienie o numerze " + orderNumber + " zostało usunęte");
            }
        }
        if (!found) {
            System.out.println("nie znaleziono zamówienia");
        }
    }

    public void removeOrderByOrderId(int orderId) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderID() == orderId) {
                orders.remove(orderId);
                found = true;
                System.out.println("Zamówienie o identyfikatorze " + orderId + " zostało usunęte");
            }
        }
        if (!found) {
            System.out.println("nie znaleziono zamówienia");
        }
    }

    public void showAllOrders() {
        boolean found = false;
        for (Order order : orders) {
            System.out.println(order);
            found = true;
        }
        if (!found){
            System.out.println("Nie ma żadnych zamówień");
        }
    }

    public Order showOrderByOrderNumber(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber().equals(orderNumber)) {
                return order;
            }
        }
        System.out.println("Nie ma takiego zamówienia");
        return null;
    }

    public void showOrderStatusByID(int orderNumber) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderNumber().equals(orderNumber)) {
                System.out.println(order.getOrderStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("nie znaleziono zamówienia");
        }
    }

    public void changeStatusByID(int orderNumber, Enum OrderStatus) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderNumber().equals(orderNumber)) {
                order.setOrderStatus(OrderStatus);
                found = true;
                System.out.println("Zmieniono status na " + OrderStatus);
            }
        }
        if (!found) {
            System.out.println("nie znaleziono zamówienia");
        }
    }
}