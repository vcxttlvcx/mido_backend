package io.cloudtype.Demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.cloudtype.Demo.dto.LoginDto;
import io.cloudtype.Demo.dto.PioneerResponseDto;
import io.cloudtype.Demo.dto.SignupDto;
import io.cloudtype.Demo.service.PioneerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pioneer")
public class PioneerController {
    private final PioneerService pioneerService;

    @PostMapping("/signup")
    public ResponseEntity<PioneerResponseDto> signup(@RequestBody SignupDto signupDto) {
        return ResponseEntity.ok(pioneerService.signup(signupDto));
    }

    @PostMapping("/login")
    public ResponseEntity<PioneerResponseDto> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(pioneerService.login(loginDto));
    }
}
