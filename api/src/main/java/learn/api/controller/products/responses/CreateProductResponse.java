package learn.api.controller.products.responses;

import learn.core.domain.Product;
import learn.core.domain.Shop;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateProductResponse(String identifier, BigDecimal price) {

    public static CreateProductResponse fromShop(Product product) {
        return new CreateProductResponse(product.identifier(), product.price());
    }
}
