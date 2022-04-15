package org.finalProject.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.finalProject.server.dto.BalanceDto;
import org.finalProject.server.exception.BalanceNotFoundException;
import org.finalProject.server.repository.BalanceRepository;
import org.finalProject.server.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    @Override
    public BalanceDto getBalance(String cardNumber) {
        return new BalanceDto(balanceRepository.findBalanceByAccountCardNumber(cardNumber)
                .orElseThrow(() -> new BalanceNotFoundException("This account doesn't have balance")).getBalance());
    }
}
