package io.cloudtype.Demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "round")
public class Round extends BaseEntity {
    @Id
    @Column(name = "round_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name="round_type")
    private int roundType;

    @Column(nullable = false, name="share_yn")
    private boolean shareYn;

    @ManyToOne
    @JoinColumn(name="MEETING_ID")
    private Meeting meeting;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;

    @Builder
    public Round(int roundType, boolean shareYn, Meeting meeting, Restaurant restaurant) {
        this.roundType = roundType;
        this.shareYn = shareYn;
        this.meeting = meeting;
        this.restaurant = restaurant;
    }
}
