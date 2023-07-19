package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Order;

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



}
