package org.example.productservice;

import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "delivery-service",
        url = "http://localhost:8082"
)
public interface DeliveryClient {

    @PostMapping("/delivery")
    String createDelivery(DeliveryRequest request);
}
