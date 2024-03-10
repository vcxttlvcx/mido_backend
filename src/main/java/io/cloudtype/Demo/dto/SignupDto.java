package io.cloudtype.Demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.cloudtype.Demo.entity.Pioneer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    private String gender;
    private String imageUrl;

    public Pioneer toPioneer() {
        return Pioneer
                .builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .birth(birth)
                .gender(gender)
                .imageUrl(imageUrl)
                .build();
    }
}
