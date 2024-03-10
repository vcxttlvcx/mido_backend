package io.cloudtype.Demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {
    @Id
    @Column(name = "restaurant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false)
    private String addr;

    @NonNull
    @Column(nullable = false)
    private String latitude;

    @NonNull
    @Column(nullable = false)
    private String longitude;

    @Column(nullable = false)
    private double avg;

    @Column(nullable = false)
    private Integer visited;

    @Builder
    public Restaurant(String name, String addr, String latitude, String longitude, double avg, Integer visited) {
        this.name = name;
        this.addr = addr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.avg = avg;
        this.visited = visited;
    }
}
