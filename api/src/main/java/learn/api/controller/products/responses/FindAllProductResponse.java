package learn.api.controller.products.responses;

import java.math.BigDecimal;

public record FindAllProductResponse(String identifier, BigDecimal price) {

}
