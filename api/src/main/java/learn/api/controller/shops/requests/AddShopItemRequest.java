package learn.api.controller.shops.requests;


import learn.core.domain.ShopItem;

public record AddShopItemRequest(String productIdentifier, int amount) {

    public ShopItem toShopItem() {
        return ShopItem.create()
                .productIdentifier(productIdentifier)
                .amount(amount);

    }

}
