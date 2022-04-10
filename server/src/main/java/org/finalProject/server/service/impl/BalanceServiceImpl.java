package org.finalProject.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.finalProject.server.dto.BalanceDTO;
import org.finalProject.server.exception.BalanceNotFoundException;
import org.finalProject.server.repository.BalanceRepository;
import org.finalProject.server.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    @Override
    public BalanceDTO getBalance(String cardNumber) {
        return new BalanceDTO(balanceRepository.findBalanceByAccountCardNumber(cardNumber)
                .orElseThrow(() -> new BalanceNotFoundException("This account doesn't have balance")).getBalance());
    }
}
