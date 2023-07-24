import org.junit.Test;
import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Product;
import pl.sda.projektPraktyczny.services.CategoryService;
import pl.sda.projektPraktyczny.services.ProductService;

import static org.junit.Assert.assertTrue;

public class CategoryServiceTest {

    @Test
    public void addCategory_Test() {

        //given
        Category categoryToAdd = new Category("Napoje");
        CategoryService categoryService = new CategoryService();

        //when
        categoryService.addCategory(categoryToAdd);

        //then
        assertTrue(CategoryService.getCategories().contains(categoryToAdd));
    }

}
