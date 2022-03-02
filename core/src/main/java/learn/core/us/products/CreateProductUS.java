package learn.core.us.products;

import learn.core.domain.Product;
import learn.core.ports.repository.products.ProductRepositoryPort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public record CreateProductUS(ProductRepositoryPort repository) {

    public Mono<Product> execute(Product product) {
        return repository.save(product);
    }

}
