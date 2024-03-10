package io.cloudtype.Demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.cloudtype.Demo.entity.BaseEntity;
import io.cloudtype.Demo.entity.Pioneer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PioneerResponseDto extends BaseEntity {
    private String email;
    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    private String gender;
    private String imageUrl;

    public static PioneerResponseDto of(Pioneer pioneer) {
        return new PioneerResponseDto(pioneer.getEmail(), pioneer.getNickname(), pioneer.getBirth(),
                pioneer.getGender(), pioneer.getImageUrl());
    }
}
