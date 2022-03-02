package learn.core.us.products;

import learn.core.ports.repository.products.ProductRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public record FindByIdentifierProductUS(ProductRepositoryPort repository) {

    public <T> Mono<T> execute(String identifier, Class<T> project) {
        return repository.findByIdentifier(identifier, project);
    }

}
