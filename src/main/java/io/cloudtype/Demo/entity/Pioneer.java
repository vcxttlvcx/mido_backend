package io.cloudtype.Demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "pioneer")
public class Pioneer extends BaseEntity {
    @Id
    @Column(name = "pioneer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String password;

    @NonNull
    @Column(nullable = false)
    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    private String gender;

    @Column(name = "image_url")
    private String imageUrl;

    @Builder
    public Pioneer(String email, String password, String nickname, LocalDate birth, String gender, String imageUrl) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }
}
