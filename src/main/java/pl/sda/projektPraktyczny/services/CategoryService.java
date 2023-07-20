package pl.sda.projektPraktyczny.services;

import pl.sda.projektPraktyczny.models.Category;

public class CategoryService extends Category {
    public void addCategory(String name){
        Category category = new Category(name);
    }
}
