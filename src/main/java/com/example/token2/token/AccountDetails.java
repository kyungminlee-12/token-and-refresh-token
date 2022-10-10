package com.example.token2.token;

import com.example.token2.account.Account;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class AccountDetails extends User {

    private final Account account;

    public AccountDetails(Account account) {
        super(account.getEmail(), account.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
        this.account = account;
    }
}