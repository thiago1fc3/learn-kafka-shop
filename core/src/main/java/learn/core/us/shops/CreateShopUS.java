package learn.core.us.shops;

import learn.core.domain.Shop;
import learn.core.ports.repository.shops.ShopRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public record CreateShopUS(ShopRepositoryPort repository) {

    public Mono<Shop> execute() {

        var shop = Shop
                .create()
                .status(Shop.Status.PENDING)
                .date(LocalDate.now());

        return repository.save(shop);
    }

}
