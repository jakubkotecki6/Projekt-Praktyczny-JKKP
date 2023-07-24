import junit.framework.Assert;
import org.junit.Test;
import pl.sda.projektPraktyczny.models.Category;
import pl.sda.projektPraktyczny.models.Product;
import pl.sda.projektPraktyczny.services.ProductService;

import static org.junit.Assert.assertTrue;

public class ProductServiceTest {

    @Test
    public void addProduct_Test() {

        //given
        Product productToAdd = new Product(4, "Chleb", new Category("Pieczywo"), 1);
        ProductService productService = new ProductService();

        //when
        productService.addProduct(productToAdd);

        //then
        assertTrue(productService.getProducts().contains(productToAdd));
    }

}
