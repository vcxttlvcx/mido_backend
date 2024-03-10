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
@Table(name = "meeting")
public class Meeting extends BaseEntity {
    @Id
    @Column(name = "meeting_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "meeting_date")
    private LocalDate meetingDate;

    @ManyToOne
    @JoinColumn(name="PARTY_ID")
    private Party party;


    @Builder
    public Meeting(LocalDate meetingDate, Party party) {
        this.meetingDate = meetingDate;
        this.party = party;
    }
}
