package learn.api.controller.products.requests;


import learn.core.domain.Product;

import java.math.BigDecimal;

public record CreateProductRequest(BigDecimal price) {

    public Product toProduct() {

        return Product.create().price(price);

    }

}
