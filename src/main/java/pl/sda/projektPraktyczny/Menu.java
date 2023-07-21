package pl.sda.projektPraktyczny;

import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Order;
import pl.sda.projektPraktyczny.models.OrderStatus;
import pl.sda.projektPraktyczny.models.Product;
import pl.sda.projektPraktyczny.services.OrderService;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Menu extends OrderService {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.loadOrdersFromFile();

        mainMenu();
    }

    private static void mainMenu() {
        OrderService orderService = new OrderService();
        System.out.println("""
                Wybierz
                 [1] Zamówienia
                 [2] Kategorie produktów
                 [3] Produkty
                 [0] Exit""");

        switch (picking(3)) {
            case 0:
                OrderService.generateOrdersList();
                break;
            case 1:
                orderMenu();
                break;
            case 2:
                categoryMenu();
                break;
            case 3:
                productMenu();
                break;
        }
    }

    private static void orderMenu() {
        OrderService orderService = new OrderService();
        int pick;

        do {
            System.out.println("""
                    Zamówienia
                    \t [1] Lista zamówień
                    \t [2] Konkretne zamówienie
                    \t [3] Dodaj zamówienie
                    \t [4] Usuń zamówienie
                    \t [5] Edytuj zamówienie
                    \t [6] Zmień status zamówienia changeStatus(CREATED)
                    \t [7] Pokaż status zamówienia
                    \t [8] Dodaj produkt do zamówienia addProductToOrder(productId, orderId, quantity)
                    \t [0] Cofnij""");

            pick = picking(8);
            switch (pick) {
                case 0 -> mainMenu();
                case 1 -> orderService.showAllOrders();
                case 2 -> orderService.showOrderByOrderNumber(getIntValue());
                case 3 -> orderService.addOrder(getOrder());
                case 4 -> whichRemove();
                case 5 -> System.out.println("""
                        Pole, pole, łyse pole, ale mam już plan.
                        Pomalutku, bez pośpiechu wszystko zrobię sam.
                        Nad makietą się męczyłem ładnych parę lat,
                        Ale za to zwiedzać cudo będzie cały świat""");
                case 6 -> orderService.changeStatusByID(getIntValue(), getOrderStatus());
                case 7 -> orderService.showOrderStatusByID(getIntValue());
                case 8 -> System.out.println("""
                        Pole, pole, łyse pole, ale mam już plan.
                        Pomalutku, bez pośpiechu wszystko zrobię sam.
                        Nad makietą się męczyłem ładnych parę lat,
                        Ale za to zwiedzać cudo będzie cały świat""");
            }
        } while (pick != 0);

    }

    private static void whichRemove() {
        OrderService orderService = new OrderService();

        System.out.println("""
                Jak chcesz usunąć obiekt
                 [1] Obiekt Order
                 [2] Numer zamówienia
                 [3] ID zamówienia
                 [0] Cofnij""");

        switch (picking(3)) {
            case 0 -> orderMenu();
            case 1 -> orderService.removeOrder(getOrder());
            case 2 -> orderService.removeOrderByOrderNumber(getIntValue());
            case 3 -> orderService.removeOrderByOrderId(getIntValue());
        }
    }

    private static void categoryMenu() {
        System.out.println("""
                Kategorie produktów
                \t [1] Lista kategorii
                \t [2] Konkretna kategoria
                \t [3] Dodaj kategorie
                \t [4] Usuń kategorie
                \t [0] Cofnij""");

        switch (picking(4)) {
            case 0:
                mainMenu();
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    private static void productMenu() {

        System.out.println("""
                Produkty
                \t [1] Lista produktów
                \t [2] Konkretny produkt
                \t [3] Dodaj produkt
                \t [4] Usuń produkt
                \t [0] Cofnij""");

        switch (picking(4)) {
            case 0:
                mainMenu();
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    private static int picking(int numberOfOptions) {
        Scanner scanner = new Scanner(System.in);
        int pick = -1;
        String input;
        do {
            input = scanner.next();
            if (isNumeric(input)){
                pick = Integer.parseInt(input);
            }else {
                System.out.println("podaj liczbę w zakresie od 0 do " + numberOfOptions);
            }
        } while (pick < 0 || pick > numberOfOptions);
        return pick;
    }

    private static int getIntValue() {
        System.out.print("Podaj liczbe: ");
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        String input;
        do {
            input = scanner.next();
            if (isNumeric(input)){
                number = Integer.parseInt(input);
            }else {
                System.out.println("Podaj liczbę!");
            }
        } while (!isNumeric(input));
        return number;
    }

    private static String getStringValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static Order getOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz sumę zamówienia, imię, nazwisko, adres, ustaw status zamówienia, dodaj produkty: ");
        return new Order(scanner.nextDouble(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), getOrderStatus(), setProductsMap()); //POWINNO BYĆ PRODUCTS
    }

    private static Product getProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz cenę, nazwę produktu, kategorię, ilość: ");
        return new Product(scanner.nextDouble(), scanner.nextLine(), getCategory(), scanner.nextInt());
    }

    private static Category getCategory() {
        System.out.println("Wpisz nazwę kategorii: ");
        return new Category(getStringValue());
    }

    private static Map<Product, Integer> setProductsMap() {
        Scanner scanner = new Scanner(System.in);
        Map<Product, Integer> products = new HashMap<>();
        int addOrFinish;
        do {
            System.out.println("aby dodać produkt do mapy wpisz 1 jeśli chcesz zakończyć dodawanie produktów wpisz cokolwiek innego");
            addOrFinish = scanner.nextInt();
            if (addOrFinish == 1) {
                products.put(getProduct(), scanner.nextInt());
            }
        } while (addOrFinish == 1);
        return products;
    }

    private static OrderStatus getOrderStatus() {
        int addOrFinish;
        do {
            System.out.println("""
                    Statusy
                    \t [0] OPLACONE
                    \t [1] ANULOWANE
                    \t [2] WYSLANE
                    \t [3] W_PRZYGOTOWANIU""");

            return switch (picking(3)) {
                case 0 -> OrderStatus.OPLACONE;
                case 1 -> OrderStatus.ANULOWANE;
                case 2 -> OrderStatus.WYSLANE;
                case 3 -> OrderStatus.W_PRZYGOTOWANIU;
                default -> null;
            };
        } while (addOrFinish < 0 && addOrFinish > 3);

    }
}
