package learn.api.controller.shops;

import learn.api.controller.shops.requests.AddShopItemRequest;
import learn.api.controller.shops.responses.AddItemShopResponse;
import learn.api.controller.shops.responses.CreateShopResponse;
import learn.core.us.shops.AddItemShopUS;
import learn.core.us.shops.CreateShopUS;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("shops")
public record ShopController(
        CreateShopUS createShopUS,
        AddItemShopUS addItemShopUS) {

    @PostMapping
    public Mono<CreateShopResponse> create() {
        return createShopUS
                .execute()
                .map(CreateShopResponse::fromShop);
    }

    @PatchMapping("{shopIdentifier}")
    public Mono<AddItemShopResponse> addItems(
            @PathVariable String shopIdentifier,
            @RequestBody List<AddShopItemRequest> request) {

        return addItemShopUS
                .execute(shopIdentifier, request.stream().map(r -> r.toShopItem()).toList())
                .map(AddItemShopResponse::fromShop);

    }

}
