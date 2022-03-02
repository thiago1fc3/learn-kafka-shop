package learn.api.controller.shops.responses;

import learn.core.domain.Shop;
import learn.core.domain.Shop.Status;

import java.time.LocalDate;

public record CreateShopResponse(String identifier, LocalDate date, Status status) {

    public static CreateShopResponse fromShop(Shop shop) {
        return new CreateShopResponse(shop.identifier(), shop.date(), shop.status());
    }

}
