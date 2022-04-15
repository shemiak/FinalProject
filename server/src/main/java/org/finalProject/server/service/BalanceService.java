package org.finalProject.server.service;

import org.finalProject.server.dto.BalanceDto;

public interface BalanceService {
    BalanceDto getBalance(String cardNumber);
}
