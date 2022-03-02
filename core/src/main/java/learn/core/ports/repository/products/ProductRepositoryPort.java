package learn.core.ports.repository.products;

import learn.core.domain.Product;
import learn.core.ports.repository.RepositoryPort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepositoryPort extends RepositoryPort<Product> {

    <T> Mono<T> findByIdentifier(String identifier, Class<T> project);

    <T> Flux<T> findBy(Class<T> project);

}
