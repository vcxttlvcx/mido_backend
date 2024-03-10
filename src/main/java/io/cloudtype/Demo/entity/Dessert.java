package io.cloudtype.Demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "dessert")
public class Dessert extends BaseEntity {
    @Id
    @Column(name = "dessert_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    private Integer price;

    private String description;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;

    @Builder
    public Dessert(String name, Integer price, String description, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }
}
