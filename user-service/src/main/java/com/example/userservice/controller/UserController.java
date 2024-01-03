package com.example.userservice.controller;

import com.example.userservice.dto.OrderDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RestTemplate restTemplate;

    private static final String USER_SERVICE = "user-service";

    private static final String BASEURL =  "http://localhost:7000/orders";

    @GetMapping("/displayOrders")
    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableOrders")
    public List<OrderDto> displayOrders(@RequestParam("category") String category) {
        String url = category == null ? BASEURL : BASEURL + "/" + category;
        return restTemplate.getForObject(url, ArrayList.class);
    }


    public List<OrderDto> getAllAvailableOrders() {
        return Stream.of(
                new OrderDto(119, "LED TV", "electronics", "white", 45000.0),
                new OrderDto(345, "Headset", "electronics", "black", 7000.0),
                new OrderDto(475, "Sound bar", "electronics", "black", 13000.0),
                new OrderDto(574, "Puma Shoes", "foot wear", "black & white", 4600.0),
                new OrderDto(678, "Vegetable chopper", "kitchen", "blue", 999.0),
                new OrderDto(532, "Oven Gloves", "kitchen", "gray", 745.0)
        ).collect(Collectors.toList());
    }

}
