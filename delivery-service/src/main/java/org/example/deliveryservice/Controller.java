package org.example.deliveryservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @PostMapping
    public String createDelivery(@RequestBody DeliveryRequest request) {
        return "Delivery created for product " +
                request.getProductId() +
                " to address " +
                request.getAddress();
    }
}
