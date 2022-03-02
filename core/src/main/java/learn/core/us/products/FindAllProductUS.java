package learn.core.us.products;

import learn.core.ports.repository.products.ProductRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public record FindAllProductUS(ProductRepositoryPort repository) {

    public <T> Flux<T> execute(Class<T> project) {
        return repository.findBy(project);
    }

}
