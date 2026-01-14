package org.example.productservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final RestTemplate restTemplate;

    public ProductService(ProductRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Product create(Product product) {
        Product saved = repository.save(product);

        DeliveryRequest request =
                new DeliveryRequest(saved.getId(), saved.getAddress());

        restTemplate.postForObject(
                "http://localhost:8082/delivery",
                request,
                String.class
        );

        return saved;
    }
}
