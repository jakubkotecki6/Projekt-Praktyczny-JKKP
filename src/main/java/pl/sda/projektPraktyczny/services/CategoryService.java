package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    List<Category> categories = new ArrayList<>();

    public List<Category> generateCategoriesList() {
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
        boolean found = false;
        for (Category categoryItem : categories) {
            System.out.println(categoryItem);
            found = true;
        }
        if (!found) {
            System.out.println("Nie ma żadnych kategorii");
        }
    }

    public void showCategoryById(List<Category> categories, int categoryId) {
        for (Category categoryItem : categories) {
            if (categoryItem.getCategoryId() == categoryId) {
                System.out.println("Category ID: " + categoryItem.getCategoryId());
                System.out.println("Category name: " + categoryItem.getName());
            }
            else System.out.println("Nie znaleziono kategorii o podanym ID");
        }
    }
}
