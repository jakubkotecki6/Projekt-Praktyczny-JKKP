package pl.sda.projektPraktyczny;

import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Order;
import pl.sda.projektPraktyczny.models.OrderStatus;
import pl.sda.projektPraktyczny.models.Product;
import pl.sda.projektPraktyczny.services.OrderService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu extends OrderService {
    public static void main(String[] args) {
        //wczytanie bazy danych
        mainMenu();
    }

    private static void mainMenu() {
        System.out.println("""
                Wybierz
                 [1] Zamówienia
                 [2] Kategorie produktów
                 [3] Produkty
                 [0] Exit""");

        switch (picking(3)) {
            case 0:
                //zapis baz danych
                //jakieś wyłączanie?
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

        switch (picking(8)) {
            case 0:
                mainMenu();
                break;
            case 1:
                orderService.showAllOrders();
                break;
            case 2:
                orderService.showOrderByOrderNumber(getIntValue());
                break;
            case 3:
                orderService.addOrder(getOrder());
                break;
            case 4:
                whichRemove();
                break;
            case 5:
                System.out.println("Pole, pole, łyse pole, ale mam już plan.\n" +
                        "Pomalutku, bez pośpiechu wszystko zrobię sam.\n" +
                        "Nad makietą się męczyłem ładnych parę lat,\n" +
                        "Ale za to zwiedzać cudo będzie cały świat");
                break;
            case 6:
                orderService.changeStatusByID(getIntValue(), getOrderStatus());
                break;
            case 7:
                orderService.showOrderStatusByID(getIntValue());
                break;
            case 8:
                System.out.println("Pole, pole, łyse pole, ale mam już plan.\n" +
                        "Pomalutku, bez pośpiechu wszystko zrobię sam.\n" +
                        "Nad makietą się męczyłem ładnych parę lat,\n" +
                        "Ale za to zwiedzać cudo będzie cały świat");
                break;
        }
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
        int pick;
        do {
            pick = scanner.nextInt();
        } while (pick < 0 || pick > numberOfOptions);
        return pick;
    }

    private static int getIntValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz nazwę kategorii: ");
        Category category = new Category(scanner.nextLine());
        return category;
    }

    private static Map<Product, Integer> setProductsMap() {
        Scanner scanner = new Scanner(System.in);
        Map<Product, Integer> products = new HashMap<>();
        int addOrFinish;
        do {
            System.out.println("aby dodać kolejny produkt do mapy wpisz 1 jeśli chcesz zakończyć dodawanie produktów wpisz cokolwiek innego");
            addOrFinish = scanner.nextInt();
            if (addOrFinish == 1) {
                products.put(getProduct(), scanner.nextInt());
            }
        } while (addOrFinish == 1);
        return products;
    }

    private static OrderStatus getOrderStatus() {
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
    }
}