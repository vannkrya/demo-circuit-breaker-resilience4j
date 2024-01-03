package com.example.catalogservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String category;
    private String color;
    private Double price;

    public Order(String name, String category, String color, Double price) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.price = price;
    }
}
