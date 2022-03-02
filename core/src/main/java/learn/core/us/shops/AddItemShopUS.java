package learn.core.us.shops;

import learn.core.domain.Product;
import learn.core.domain.Shop;
import learn.core.domain.ShopItem;
import learn.core.ports.repository.shops.ShopRepositoryPort;
import learn.core.us.products.FindByIdentifierProductUS;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public record AddItemShopUS(
        ShopRepositoryPort repository,
        FindByIdentifierProductUS findByIdentifierProductUS) {

    public Mono<Shop> execute(String shopIdentifier, List<ShopItem> items) {

        return getShopWithItems(shopIdentifier, items)
                .flatMap(repository::save)
                .switchIfEmpty(Mono.error(new NoSuchElementException("Shop not found!")));

    }

    private Mono<Shop> getShopWithItems(String shopIdentifier, List<ShopItem> items) {

        return getShopByIdentifier(shopIdentifier)
                .zipWith(mergeItemsWithProduct(items))
                .doOnNext((s) -> s.getT1().add(s.getT2()))
                .map(s -> s.getT1());

    }

    private Mono<Shop> getShopByIdentifier(String shopIdentifier) {
        return repository.findByIdentifier(shopIdentifier, Shop.class);
    }

    private Mono<List<ShopItem>> mergeItemsWithProduct(List<ShopItem> items) {
        return Flux.fromIterable(items)
                .flatMap(i -> mapItemWithProduct(i))
                .collectList();
    }

    private Mono<ShopItem> mapItemWithProduct(ShopItem i) {
        return findByIdentifierProductUS
                .execute(i.productIdentifier(), Product.class)
                .map(p -> i.price(p.price()));
    }

}
