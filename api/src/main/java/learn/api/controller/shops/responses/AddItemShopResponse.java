package learn.api.controller.shops.responses;

import learn.core.domain.Shop;
import learn.core.domain.ShopItem;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record AddItemShopResponse(
        String identifier, LocalDate date, Shop.Status status, List<ItemShopResponse> items) {

    public static AddItemShopResponse fromShop(Shop shop) {
        return new AddItemShopResponse(
                shop.identifier(),
                shop.date(),
                shop.status(),
                shop.items().stream().map(ItemShopResponse::fromShopItem).toList()
        );
    }

    public record ItemShopResponse(BigDecimal price, int amount, String productIdentifier) {

        public static ItemShopResponse fromShopItem(ShopItem shopItem) {
            return new ItemShopResponse(
                    shopItem.price(),
                    shopItem.amount(),
                    shopItem.productIdentifier()
            );
        }

    }
}
