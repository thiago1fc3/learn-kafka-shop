package learn.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class Product {

    private String id;

    private BigDecimal price;

    @Indexed(unique = true)
    private String identifier;


    public static Product create() {
        return new Product()
                .identifier(UUID.randomUUID().toString());
    }

}
