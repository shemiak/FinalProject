package org.finalProject.server.service.impl;

import lombok.*;
import org.finalProject.server.dto.BalanceDTO;
import org.finalProject.server.entity.Account;
import org.finalProject.server.repository.AccountRepository;
import org.finalProject.server.repository.BalanceRepository;
import org.finalProject.server.service.BalanceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;
    private final AccountRepository accountRepository;

    @Override
    public BalanceDTO getBalance(String cardNumber) {
        if ("default".equals(cardNumber)) {
            return new BalanceDTO(BigDecimal.TEN);
        }
        return new BalanceDTO(balanceRepository.findBalanceByAccountCardNumber(cardNumber).getBalance());
    }

    public Account findAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }
}
