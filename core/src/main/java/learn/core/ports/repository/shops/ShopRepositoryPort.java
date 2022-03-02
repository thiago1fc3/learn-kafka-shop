package learn.core.ports.repository.shops;

import learn.core.domain.Shop;
import learn.core.ports.repository.RepositoryPort;
import reactor.core.publisher.Mono;

public interface ShopRepositoryPort extends RepositoryPort<Shop> {

    <T> Mono<T> findByIdentifier(String identifier, Class<T> project);

}
