package learn.api.controller.products;

import learn.api.controller.products.requests.CreateProductRequest;
import learn.api.controller.products.responses.CreateProductResponse;
import learn.api.controller.products.responses.FindAllProductResponse;
import learn.core.us.products.CreateProductUS;
import learn.core.us.products.FindAllProductUS;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public record ProductController(
        CreateProductUS createProductUS,
        FindAllProductUS findAllProductUS) {

    @PostMapping
    public Mono<CreateProductResponse> create(@RequestBody CreateProductRequest request) {
        return createProductUS
                .execute(request.toProduct())
                .map(CreateProductResponse::fromShop);
    }


    @GetMapping
    public Flux<FindAllProductResponse> findAll() {
        return findAllProductUS
                .execute(FindAllProductResponse.class);
    }

}
