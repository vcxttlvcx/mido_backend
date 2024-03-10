package io.cloudtype.Demo.service;

import org.springframework.stereotype.Service;

import io.cloudtype.Demo.dto.LoginDto;
import io.cloudtype.Demo.dto.PioneerResponseDto;
import io.cloudtype.Demo.dto.SignupDto;
import io.cloudtype.Demo.entity.Pioneer;
import io.cloudtype.Demo.repository.PioneerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PioneerService {
    private final PioneerRepository pioneerRepository;

    public PioneerResponseDto signup(SignupDto signupDto) {
        if (pioneerRepository.existsByEmail(signupDto.getEmail()))
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");

        Pioneer pioneer = Pioneer
                .builder()
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .nickname(signupDto.getNickname())
                .birth(signupDto.getBirth())
                .gender(signupDto.getGender())
                .imageUrl(signupDto.getImageUrl())
                .build();
        ;

        return PioneerResponseDto.of(pioneerRepository.save(pioneer));
    }

    public PioneerResponseDto login(LoginDto loginDto) {
        return pioneerRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())
                .map(PioneerResponseDto::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }
}
