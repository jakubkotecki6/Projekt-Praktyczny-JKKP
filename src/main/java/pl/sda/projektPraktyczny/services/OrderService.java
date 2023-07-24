package pl.sda.projektPraktyczny.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import pl.sda.projektPraktyczny.models.Order;
import pl.sda.projektPraktyczny.models.OrderStatus;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class OrderService {
    private static List<Order> orders = new ArrayList<>();


    public static void generateOrdersList() {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("OrdersDB.JSON")) {
            gson.toJson(orders, writer);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania listy zamówień " + e.getMessage());
        }
    }

    public void loadOrdersFromFile() {
        try (Reader reader = new FileReader("OrdersDB.JSON")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<ArrayList<Order>>(){}.getType();
            orders = gson.fromJson(reader, type);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytywania listy zamówień " + e.getMessage());
        }
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
        return null;
    }

    public void showOrderStatusByOrderNumber(int orderNumber) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getOrderNumber().equals(String.valueOf(orderNumber))) {
                System.out.println(order.getOrderStatus());
                found = true;
            }
        }
        notFound(found);
    }


    public void changeStatusByOrderNumber(int orderNumber, OrderStatus orderStatus) {
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

    public void notFound(boolean found) {
        if (!found) {
            System.out.println("nie znaleziono zamówienia");
        }
    }
}