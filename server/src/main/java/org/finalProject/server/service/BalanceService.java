package org.finalProject.server.service;

import org.finalProject.server.dto.BalanceDTO;

public interface BalanceService {
    BalanceDTO getBalance(String cardNumber);
}
