package learn.repository;

import learn.core.domain.Shop;
import learn.core.ports.repository.shops.ShopRepositoryPort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ShopRepository extends ShopRepositoryPort, ReactiveMongoRepository<Shop, String> {

}
