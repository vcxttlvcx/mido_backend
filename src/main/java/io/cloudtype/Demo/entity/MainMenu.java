package io.cloudtype.Demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.net.Inet4Address;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "main_menu")
public class MainMenu extends BaseEntity {
    @Id
    @Column(name = "main_menu_id")
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
    public MainMenu(String name, Integer price, String description, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }
}
