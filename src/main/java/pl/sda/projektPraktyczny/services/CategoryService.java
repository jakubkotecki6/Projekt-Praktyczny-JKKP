package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CategoryService {

    public static List<Category> categories = new ArrayList<>();

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