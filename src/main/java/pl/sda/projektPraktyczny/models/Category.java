package pl.sda.projektPraktyczny.models;

import java.util.Objects;

public class Category {

    private final int categoryId;
    private static int lastCategoryId = 0;
    private final String name;

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

    public String getName() {
        return name;
    }

    private boolean isValidName(String name) {
        return name != null && !name.isBlank() && name.length() > 0 && name.length() < 50;
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
        return getCategoryId() == category.getCategoryId() && lastCategoryId == category.lastCategoryId && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategoryId(), lastCategoryId, getName());
    }
}
