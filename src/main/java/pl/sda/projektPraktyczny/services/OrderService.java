package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Order;
import pl.sda.projektPraktyczny.models.OrderStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static List<Order> orders = new ArrayList<>();

    public void generateOrdersList() {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("lista_zamowien.txt"))) {
            for (Order order : orders) {
                writer.write(order.toString());
                writer.newLine();
            }
            System.out.println("Lista zamówień zapisana do pliku");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania listy: " + e.getMessage());
        }
    }

    public List<Order> loadOrdersFromFile() {
        //wczytanie linijek pliku do nowej listy
        return null;
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
            if (order.getOrderNumber().equals(String.valueOf(orderNumber))) {
                orders.remove(order);
                found = true;
                System.out.println("Zamówienie o numerze " + orderNumber + " zostało usunęte");
            }
        }
        notFound(found);
    }

    public void removeOrderByOrderId(int orderId) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderID() == orderId) {
                orders.remove(order);
                found = true;
                System.out.println("Zamówienie o identyfikatorze " + orderId + " zostało usunęte");
            }
        }
        notFound(found);
    }

    public void showAllOrders() {
        boolean found = false;
        for (Order order : orders) {
            System.out.println(order);
            found = true;
        }
        notFound(found);
    }

    public Order showOrderByOrderNumber(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber().equals(String.valueOf(orderNumber))) {
                return order;
            }
        }
        System.out.println("Nie ma takiego zamówienia");
        return null;
    }

    public void showOrderStatusByID(int orderNumber) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderNumber().equals(String.valueOf(orderNumber))) {
                System.out.println(order.getOrderStatus());
                found = true;
            }
        }
        notFound(found);

    }

    public void changeStatusByID(int orderNumber, OrderStatus orderStatus) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderNumber().equals(String.valueOf(orderNumber))) {
                order.setOrderStatus(orderStatus);
                found = true;
                System.out.println("Zmieniono status na " + orderStatus);
            }
        }
        notFound(found);
    }
    public void notFound(boolean found){
        if (!found) {
            System.out.println("nie znaleziono zamówienia");
        }
    }
}