package com.example.token2.account;

import lombok.Builder;
import lombok.Getter;

@Getter
// @AllArgsConstructor
// @NoArgsConstructor
public class SignUpRequest {

    private String email;

    private String password;

    private String nickname;


    @Builder
    public SignUpRequest(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public SignUpRequest() {

    }
}