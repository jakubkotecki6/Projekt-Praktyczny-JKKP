package pl.sda.projektPraktyczny.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import pl.sda.projektPraktyczny.models.Category;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryService {

    public static List<Category> categories = new ArrayList<>();

    public static void generateCategoriesList() {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("CategoriesDB.JSON")) {
            gson.toJson(categories, writer);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisywania listy zamówień " + e.getMessage());
        }
    }

    public void loadCategoriesFromFile() {
        try (Reader reader = new FileReader("CategoriesDB.JSON")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Type type = new TypeToken<ArrayList<Category>>(){}.getType();
            categories = gson.fromJson(reader, type);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas odczytywania listy zamówień " + e.getMessage());
        }
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
        System.out.println("Kategoria została dodana");
    }

    public void removeCategory(Category category) {
        categories.remove(category);
        System.out.println("Kategoria została usunięta");
    }

    public void showAllCategories() {
        for (Category categoryItem : categories) {
            System.out.println(categoryItem);
        }
    }

    public void showCategoryById(int categoryId) {
        Optional<Category> firstItem = categories.stream()
                .filter(category -> category.getCategoryId() == categoryId)
                .findFirst();

        if (firstItem.isPresent()) {
            System.out.println("Kategoria o podanym ID to: " + firstItem.get());
        } else {
            System.out.println("Nie znaleziono kategorii o podanym ID");
        }
    }
}