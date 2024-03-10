package io.cloudtype.Demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "round_evaluation")
public class RoundEvaluation extends BaseEntity {
    @Id
    @Column(name = "round_evaluation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="total_score")
    private double totalScore;

    @Column(name="food_score")
    private double foodScore;

    @Column(name="service_score")
    private double serviceScore;

    @Column(name="price_score")
    private double priceScore;

    @Column(name="atmosphere_score")
    private double atmosphereScore;

    private String review;

    @ManyToOne
    @JoinColumn(name="PIONEER_ID")
    private Pioneer pioneer;

    @ManyToOne
    @JoinColumn(name="ROUND_ID")
    private Round round;

    @Builder
    public RoundEvaluation(double totalScore, double foodScore, double serviceScore, double priceScore, double atmosphereScore, String review, Round round, Pioneer pioneer) {
        this.totalScore = totalScore;
        this.foodScore = foodScore;
        this.serviceScore = serviceScore;
        this.priceScore = priceScore;
        this.atmosphereScore = atmosphereScore;
        this.review = review;
        this.pioneer = pioneer;
        this.round = round;
    }
}
