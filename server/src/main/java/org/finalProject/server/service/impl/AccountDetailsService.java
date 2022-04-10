package org.finalProject.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.finalProject.server.utils.AccountDetails;
import org.finalProject.server.entity.Account;
import org.finalProject.server.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountDetailsService implements UserDetailsService {

    private final AccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String cardNumber) throws UsernameNotFoundException {
        Optional<Account> account = repository.findAccountByCardNumber(cardNumber);

        return new AccountDetails(account.orElseThrow(() -> new UsernameNotFoundException("Account not found")));
    }
}
