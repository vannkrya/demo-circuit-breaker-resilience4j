package com.example.catalogservice.controller;

import com.example.catalogservice.entity.Order;
import com.example.catalogservice.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

//    @PostConstruct
//    public void initOrderTable() {
//        orderRepository.saveAll(Stream.of(
//                        new Order("mobile", "electronics", "white", 20000),
//                        new Order("T-Shirt", "clothes", "black", 999),
//                        new Order("Jeans", "clothes", "blue", 1999),
//                        new Order("Laptop", "electronics", "gray", 50000),
//                        new Order("digital watch", "electronics", "black", 2500),
//                        new Order("Fan", "electronics", "black", 50000)
//                ).
//                collect(Collectors.toList()));
//    }


    @GetMapping
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
    @GetMapping("/{category}")
    public List<Order> getOrdersByCategory(@PathVariable String category){
        return orderRepository.findByCategory(category);
    }

}
