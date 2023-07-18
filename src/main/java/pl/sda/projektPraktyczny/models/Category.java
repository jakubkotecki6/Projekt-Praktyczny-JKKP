package pl.sda.projektPraktyczny.models;

import java.util.Objects;

public class Category {

    int categoryId;
    int lastCategoryId = 0;
    String name;

    public Category(String name) {
        this.categoryId = ++lastCategoryId;

        if (!isValidName(name)) {
            throw new IllegalArgumentException("Nazwa nie może być pusta oraz nazwa może mieć max 50 znaków!");
        }
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
                ", lastCategoryId=" + lastCategoryId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return getCategoryId() == category.getCategoryId() && lastCategoryId == category.lastCategoryId && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), lastCategoryId, getName());
    }
}
