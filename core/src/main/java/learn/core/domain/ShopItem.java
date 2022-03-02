package learn.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@EqualsAndHashCode(of = "productIdentifier")
public class ShopItem {

    private BigDecimal price;

    private int amount;

    private String productIdentifier;

    public static ShopItem create() {
        return new ShopItem();
    }

}
