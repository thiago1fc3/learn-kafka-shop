package learn.core.ports.repository;

import reactor.core.publisher.Mono;

public interface RepositoryPort<T> {

    <S extends T> Mono<S> save(S t);

    <S> Mono<S> findById(String id, Class<S> projection);

}
