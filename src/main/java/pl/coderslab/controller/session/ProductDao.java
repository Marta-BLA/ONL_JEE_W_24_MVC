package pl.coderslab.controller.session;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductDao {

    private static final List<Product> products = Arrays.asList(
            new Product(1, "Chleb", 2.56),
            new Product(2, "Ser", 4.67),
            new Product(3, "Mleko", 6.34)
    );

    public Product getProductById(long id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no product with id: " + id));
    }

}
