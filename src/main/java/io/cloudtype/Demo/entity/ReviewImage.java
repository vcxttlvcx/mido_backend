package io.cloudtype.Demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review_image")
public class ReviewImage extends BaseEntity {
    @Id
    @Column(name = "review_image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name="PIONEER_ID")
    private Pioneer pioneer;

    @ManyToOne
    @JoinColumn(name="ROUND_ID")
    private Round round;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;

    @Builder
    public ReviewImage(String location, Pioneer pioneer, Round round, Restaurant restaurant) {
        this.location = location;
        this.pioneer = pioneer;
        this.round = round;
        this.restaurant = restaurant;
    }
}
