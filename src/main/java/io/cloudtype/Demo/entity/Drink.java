package io.cloudtype.Demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "drink")
public class Drink extends BaseEntity {
    @Id
    @Column(name = "drink_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    private Integer price;

    @Column(nullable = false, name = "alcohol_yn")
    private boolean alcoholYn;

    private double percent;

    private String description;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;

    @Builder
    public Drink(String name, Integer price, Boolean alcoholYn, double percent, String description, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.alcoholYn = alcoholYn;
        this.percent = percent;
        this.description = description;
        this.restaurant = restaurant;
    }
}
