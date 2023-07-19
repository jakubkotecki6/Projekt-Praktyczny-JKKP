package pl.sda.projektPraktyczny.models;

import java.util.Objects;

public class Category {

    private static int lastCategoryId = 1;
    private int categoryId;
    String name;

    public Category(String name) {
        this.categoryId = lastCategoryId++;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isValidName(String name) {
        return name != null && name.isBlank() && name.length() > 0 && name.length() < 50;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getCategoryId() == category.getCategoryId() && categoryId == category.categoryId && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), categoryId, getName());
    }
}
