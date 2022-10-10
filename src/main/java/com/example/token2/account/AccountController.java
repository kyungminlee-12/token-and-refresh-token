package com.example.token2.account;

import com.example.token2.jwt.JwtProvider;
import com.example.token2.jwt.TokenResponse;
import com.example.token2.token.AccountDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final JwtProvider jwtProvider;

    @PostMapping("/sign-up")
    public AccountResponse signUp(
            @RequestBody SignUpRequest signUpRequest
    ) {
        return accountService.signUp(signUpRequest);
    }


    @PostMapping("/login")
    public TokenResponse login(
            @RequestBody LoginRequest loginRequest
    ) throws JsonProcessingException {
        AccountResponse accountResponse = accountService.login(loginRequest);
        return jwtProvider.createTokensByLogin(accountResponse);
    }

    @GetMapping("/reissue")
    public TokenResponse reissue(
            @AuthenticationPrincipal AccountDetails accountDetails
    ) throws JsonProcessingException {
        AccountResponse accountResponse = AccountResponse.of(accountDetails.getAccount());
        return jwtProvider.reissueAtk(accountResponse);
    }
}