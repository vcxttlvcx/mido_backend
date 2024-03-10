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
@Table(name = "party")
public class Party extends BaseEntity {
    @Id
    @Column(name = "party_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "max_personnel")
    private Integer maxPersonnel;

    @Column(nullable = false, name = "leader_id")
    private long leaderId;

    @ManyToOne
    @JoinColumn(name="PIONEER_ID")
    private Pioneer pioneer;

    @Builder
    public Party(String name, int maxPersonnel, long leaderId, Pioneer pioneer) {
        this.name = name;
        this.maxPersonnel = maxPersonnel;
        this.leaderId = leaderId;
        this.pioneer = pioneer;
    }
}
