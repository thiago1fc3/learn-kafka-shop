package learn.repository;

import learn.core.domain.Product;
import learn.core.domain.Shop;
import learn.core.ports.repository.products.ProductRepositoryPort;
import learn.core.ports.repository.shops.ShopRepositoryPort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ProductRepositoryPort, ReactiveMongoRepository<Product, String> {

}
